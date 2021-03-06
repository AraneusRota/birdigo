package violetempiregames.scenes

import indigo.*
import indigo.scenes.*
import indigo.shared.events.KeyboardEvent.KeyDown
import violetempiregames.Model
import violetempiregames.init.{Assets, ViewConfig}
import violetempiregames.scenes.model.{Bird, Obstacle}
import violetempiregames.scenes.view.{BackgroundView, BirdView, ObstaclesView, ScoreView, View}

object GameScene extends Scene[Unit, Model, Unit] :

  override type SceneModel = Model
  override type SceneViewModel = Unit

  override val name: SceneName =
    SceneName("game")

  override val modelLens: Lens[Model, Model] =
    Lens.keepLatest

  override val viewModelLens: Lens[Unit, Unit] =
    Lens.keepLatest

  override val eventFilters: EventFilters =
    EventFilters.Permissive

  override val subSystems: Set[SubSystem] =
    Set()

  override def updateModel(
                   context: FrameContext[Unit],
                   model: Model
                 ): GlobalEvent => Outcome[Model] = _ =>
    val updatedObstacles = model.obstacles.map(_.update(context.gameTime)).filter(_.isDefined).flatten

    val (nonEmptyUpdatedObstacles, updatedScore) =
      if updatedObstacles.isEmpty then
        if model.score == 0 then
          (List(Obstacle.withRandomGapFarRight(context.dice)), model.score + 1)
        else
          (List(Obstacle.withRandomGap(context.dice)), model.score + 1)
      else
        (updatedObstacles, model.score)

    val updatedHighScore = if updatedScore > model.highScore then updatedScore else model.highScore

    model.bird.update(context.gameTime, context.inputState, model.obstacles) match
      case Some(updatedBird) =>
        Outcome(Model(updatedBird, nonEmptyUpdatedObstacles, updatedScore, updatedHighScore))
      case None =>
        Outcome(model.resetButKeepHighScore).addGlobalEvents(SceneEvent.Previous)


  override def updateViewModel(
    context: FrameContext[Unit],
    model: Model,
    viewModel: Unit
  ): GlobalEvent => Outcome[Unit] =
    _ => Outcome(viewModel)

  override def present(
    context: FrameContext[Unit],
    model: Model,
    viewModel: Unit
  ): Outcome[SceneUpdateFragment] =
    val birdView = BirdView(model.bird)
    Outcome(
      SceneUpdateFragment(
        ObstaclesView(model.obstacles)
          .appended(birdView.graphic)
          .appended(ScoreView.normal(model.score))
          .appended(BackgroundView())
      )
        .withLights(
          birdView.light,
          AmbientLight(RGBA.White.withAmount(0.1))
        )
    )
