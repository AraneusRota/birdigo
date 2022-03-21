package violetempiregames.scenes.view

import indigo._
import violetempiregames.init.{Assets, ViewConfig}

object BackgroundView:
  def apply() = Graphic(
    ViewConfig.default.viewport.toRectangle,
    2,
    Material.Bitmap(
      Assets.background.albedo,
      LightingModel.Lit(
        Assets.background.emission,
        Assets.background.normal
      )
    )
  )

