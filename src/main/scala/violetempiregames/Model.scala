package violetempiregames

import violetempiregames.scenes.model.{Bird, Obstacle}

case class Model(bird: Bird, obstacles: List[Obstacle], score: Int, highScore: Int):
  def resetButKeepHighScore: Model = Model.initial.copy(highScore = highScore)

object Model:
  def initial: Model = Model(Bird.initial, List.empty, 0, 0)
  