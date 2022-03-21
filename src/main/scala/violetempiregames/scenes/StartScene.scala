package violetempiregames.scenes

import indigo.*
import indigo.scenes.*
import indigo.scenes.SceneEvent.JumpTo
import indigo.shared.events.KeyboardEvent.KeyDown
import violetempiregames.Model
import violetempiregames.init.{FontAssets, ViewConfig}
import violetempiregames.scenes.view.{BackgroundView, ScoreView}

object StartScene extends Scene[Unit, Model, Unit] :

  override type SceneModel = Int
  override type SceneViewModel = Unit

  override val name: SceneName =
    SceneName("start")

  override val modelLens: Lens[Model, Int] =
    Lens(_.highScore, (m, hs) => m.copy(highScore = hs))

  override val viewModelLens: Lens[Unit, Unit] =
    Lens.keepLatest

  override val eventFilters: EventFilters =
    EventFilters.Permissive

  override val subSystems: Set[SubSystem] =
    Set()

  override def updateModel(
                   context: FrameContext[Unit],
                   model: Int
                 ): GlobalEvent => Outcome[Int] =
    case KeyDown(Key.SPACE) | MouseEvent.Click(_) => Outcome(model).addGlobalEvents(SceneEvent.Next)
    case _ => Outcome(model)


  override def updateViewModel(
                       context: FrameContext[Unit],
                       model: Int,
                       viewModel: Unit
                     ): GlobalEvent => Outcome[Unit] =
    _ => Outcome(viewModel)

  override def present(
               context: FrameContext[Unit],
               model: Int,
               viewModel: Unit
             ): Outcome[SceneUpdateFragment] =
    Outcome(
      SceneUpdateFragment(
        ScoreView.highScore(model),
        Text(
          "Space!",
          ViewConfig.default.horizontalCenter,
          ViewConfig.default.verticalMiddle,
          1,
          FontAssets.fontKey,
          FontAssets.fontMaterial
        ).alignCenter,
        BackgroundView()
      ),
    )
