package violetempiregames.scenes.view

import indigo.shared.datatypes.Rectangle
import indigoextras.geometry.{BoundingBox, Vertex}
import violetempiregames.init.ViewConfig
import violetempiregames.scenes.model.PlayArea

object View:
  private val viewport = ViewConfig.default.viewport
  private val horizontalScale = viewport.width / PlayArea.width
  private val verticalScale = viewport.height / PlayArea.height

  def fromBoundingBox(boundingBox: BoundingBox): Rectangle =
    def scale(vertex: Vertex) = Vertex(fromX(vertex.x), fromY(vertex.y))

    BoundingBox(scale(boundingBox.size))
      .moveTo(scale(boundingBox.position))
      .toRectangle

  def fromX(x: Double): Int = (x * horizontalScale).round.toInt
  def fromY(y: Double): Int = (y * verticalScale).round.toInt
