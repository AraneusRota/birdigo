package violetempiregames.scenes.view

import indigo.*
import indigo.shared.scenegraph.{SceneUpdateFragment, Shape}
import violetempiregames.init.GameAssets
import violetempiregames.scenes.model.Bird

object BirdView:
  def apply(bird: Bird): SceneNode =
    Graphic(
      Rectangle(View.size(bird.boundingBox.size)),
      Material.Bitmap(if bird.ySpeed < 14 then GameAssets.bird.rise else GameAssets.bird.fall)
    )
      .moveTo(View.point(bird.boundingBox.position))
