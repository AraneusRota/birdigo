package violetempiregames.scenes.view

import indigo._
import indigo.shared.scenegraph.{SceneUpdateFragment, Shape}
import violetempiregames.scenes.model.Bird

object BirdView:
  def apply(bird: Bird): Shape.Box = Shape.Box(
    View.fromBoundingBox(bird.boundingBox),
    Fill.LinearGradient(Point(0), RGBA.Magenta, Point(45), RGBA.Cyan)
  )
