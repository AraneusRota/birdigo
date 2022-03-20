package violetempiregames.scenes.view

import indigo.*
import indigoextras.geometry.BoundingBox
import violetempiregames.init.GameAssets
import violetempiregames.scenes.model.Obstacle

object ObstaclesView:
  def apply(obstacles: List[Obstacle]): List[SceneNode] =
    val fill = Fill.LinearGradient(Point(0), RGBA.Green, Point(45), RGBA.Teal)

    val tileHeight = 64
    val tileWidth = 64
    Graphic(Rectangle(0, 0), Material.Bitmap(GameAssets.obstacle.mid))

    def toGraphic(obstacle: BoundingBox) =
      Graphic(
        View.size(obstacle.size),
        Material.Bitmap(GameAssets.obstacle.mid).tile
      )
        .moveTo(View.point(obstacle.position))

    obstacles.flatMap { obstacle =>
      List(
        toGraphic(obstacle.top).flipVertical(true),
        toGraphic(obstacle.bottom)
      )
    }