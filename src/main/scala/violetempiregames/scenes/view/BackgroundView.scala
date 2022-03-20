package violetempiregames.scenes.view

import indigo._
import violetempiregames.init.{GameAssets, ViewConfig}

object BackgroundView:
  def apply() = Graphic(
    ViewConfig.default.viewport.toRectangle,
    100,
    Material.Bitmap(GameAssets.background)
  )

