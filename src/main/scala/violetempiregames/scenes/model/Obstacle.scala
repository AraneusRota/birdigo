package violetempiregames.scenes.model

import indigo.shared.dice.Dice
import indigo.shared.time.GameTime
import indigoextras.geometry.{BoundingBox, Vertex}

final case class Obstacle(top: BoundingBox, bottom: BoundingBox):
  /**
   * Some if in bounds, None if out of bounds
   */
  def update(gameTime: GameTime): Option[Obstacle] =
    val velocity = -9
    val moved = moveHorizontallyBy(velocity * gameTime.delta.toDouble)
    if moved.top.right > 0 then Some(moved) else None

  def moveHorizontallyBy(x: Double): Obstacle =
    Obstacle(
      top.moveBy(x, 0),
      bottom.moveBy(x, 0)
    )

  def hits(box: BoundingBox): Boolean = box.overlaps(top) || box.overlaps(bottom)

object Obstacle:
  def withRandomGap(dice: Dice): Obstacle =
    val width = 3d
    val gapSize = 5d
    val buffer = 2d
    val maxGapStart = PlayArea.height - gapSize - buffer
    val gapStart = dice.rollDouble * (maxGapStart - buffer) + buffer
    val gapEnd = gapStart + gapSize
    val bottomObstacleHeight = PlayArea.height - gapEnd
    Obstacle(
      BoundingBox(width, gapStart).moveTo(PlayArea.topRight),
      BoundingBox(width, bottomObstacleHeight).moveTo(PlayArea.bottomRight - Vertex(0, bottomObstacleHeight))
    )

  def withRandomGapFarRight(dice: Dice): Obstacle =
    withRandomGap(dice).moveHorizontallyBy(PlayArea.width)



