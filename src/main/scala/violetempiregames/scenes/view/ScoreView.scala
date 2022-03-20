package violetempiregames.scenes.view

import indigo.*
import violetempiregames.init.FontAssets
import violetempiregames.scenes.model.PlayArea

object ScoreView:
  def apply(score: Int): SceneNode = Text(
    s"$score",
    View.x(PlayArea.horizontalCenter),
    View.y(PlayArea.top + 4), 1,
    FontAssets.fontKey,
    FontAssets.fontMaterial
  )


