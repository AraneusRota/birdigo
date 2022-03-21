package violetempiregames.scenes.view

import indigo.*
import indigo.shared.scenegraph.{SceneUpdateFragment, Shape}
import violetempiregames.init.Assets
import violetempiregames.scenes.model.Bird

final case class BirdView(graphic: SceneNode, light: Light)

object BirdView:
  def apply(bird: Bird): BirdView =
    val graphic =
      Graphic(
        Rectangle(View.size(bird.boundingBox.size)),
        Material.Bitmap(if bird.ySpeed < 14 then Assets.bird.rise else Assets.bird.fall)
      )
        .moveTo(View.point(bird.boundingBox.position))
    val light = PointLight.default
      .withColor(RGBA.Orange.mix(RGBA.White, 0.05))
      .withIntensity(100)
      .withFalloff(Falloff.Linear(0, 350))
      .moveTo(graphic.bounds.center)
    BirdView(graphic, light)
