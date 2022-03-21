package violetempiregames.scenes.view

import indigo.*
import indigoextras.geometry.BoundingBox
import violetempiregames.init.Assets
import violetempiregames.scenes.model.Obstacle

object ObstaclesView:
  def apply(obstacles: List[Obstacle]): List[SceneNode] =
    val fill = Fill.LinearGradient(Point(0), RGBA.Green, Point(45), RGBA.Teal)

    def toGraphic(obstacle: BoundingBox) =
      Graphic(
        View.size(obstacle.size),
        Material.Bitmap(
          Assets.obstacle.mid.albedo,
          LightingModel.Lit(
            Assets.obstacle.mid.emission,
            Assets.obstacle.mid.normal
          )
            .withNormalAmount(1.5)
        ).tile
      )
        .moveTo(View.point(obstacle.position))

    obstacles.flatMap { obstacle =>
      List(
        toGraphic(obstacle.top).flipVertical(true),
        toGraphic(obstacle.bottom)
      )
    }