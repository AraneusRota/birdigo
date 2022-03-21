package violetempiregames.scenes.view

import indigo.*
import violetempiregames.init.FontAssets
import violetempiregames.scenes.model.PlayArea

object ScoreView:
  def normal(score: Int): SceneNode = text(score, "")
  def highScore(highScore: Int): SceneNode = text(highScore, "Hi-Score:\n")

  private def text(score: Int, prefix: String): SceneNode = Text(
    s"$prefix$score",
    View.x(PlayArea.horizontalCenter),
    View.y(PlayArea.top + 3),
    1,
    FontAssets.fontKey,
    FontAssets.fontMaterial
  ).alignCenter


