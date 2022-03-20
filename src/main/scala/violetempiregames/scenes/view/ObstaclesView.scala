package violetempiregames.scenes.view

import indigo.*
import indigoextras.geometry.BoundingBox
import violetempiregames.scenes.model.Obstacle

object ObstaclesView:
  def apply(obstacles: List[Obstacle]): List[Shape.Box] =
    val fill = Fill.LinearGradient(Point(0), RGBA.Green, Point(45), RGBA.Teal)

    def box(obstacle: BoundingBox): Shape.Box = Shape.Box(
        View.fromBoundingBox(obstacle),
        fill
      )

    obstacles.flatMap { obstacle => List(
        box(obstacle.top),
        box(obstacle.bottom)
      )
    }