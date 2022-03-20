package violetempiregames.scenes.model

import indigo.shared.constants.Key
import indigo.shared.events.InputState
import indigo.shared.time.GameTime
import indigoextras.geometry.{BoundingBox, Line, LineSegment, Vertex}
import violetempiregames.scenes.model.PlayArea

final case class Bird(boundingBox: BoundingBox, ySpeed: Double):
  /**
   * Some if still alive, None if dead (because out of bounds or obstacle hit)
   */
  def update(gameTime: GameTime, inputState: InputState, obstacles: List[Obstacle]): Option[Bird] =
    val gravity = 35d
    val jumpVelocity = -12d
    val newYSpeed =
      if inputState.mouse.mouseClicked || inputState.keyboard.keysAreDown(Key.SPACE) then
        jumpVelocity
      else
        gravity * gameTime.delta.toDouble + ySpeed
    val newPosition = boundingBox.moveBy(0, ySpeed * gameTime.delta.toDouble)
    val inBounds = PlayArea.boundingBox.encompasses(newPosition)
    val hitsObstacle = obstacles.exists(_.hits(boundingBox))
    if inBounds && !hitsObstacle then Some(Bird(newPosition, newYSpeed)) else None

object Bird:
  val initial: Bird = Bird(BoundingBox(1, 1).moveTo(PlayArea.horizontalCenter, PlayArea.verticalMiddle), 0)