package violetempiregames.init

import indigo._

final case class ViewConfig(
                             magnificationLevel: Int,
                             viewport: GameViewport
                           ):
  val horizontalCenter: Int = (viewport.width / magnificationLevel) / 2
  val verticalMiddle: Int   = (viewport.height / magnificationLevel) / 2

object ViewConfig:
  val default: ViewConfig = ViewConfig(1, GameViewport(640, 640))
