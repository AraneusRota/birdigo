package violetempiregames.scenes.model

import indigoextras.geometry.{BoundingBox, LineSegment, Vertex}

object PlayArea:
  val height: Double = 20
  val width: Double = 20
  
  val horizontalCenter: Double = width / 2
  val verticalMiddle: Double = height / 2
  
  val topLeft: Vertex = Vertex(0, 0)
  val topRight: Vertex = Vertex(width, 0)
  val bottomLeft: Vertex = Vertex(0, height)
  val bottomRight: Vertex = Vertex(width, height)
  
  val top: Double = 0
  val bottom: Double = height
  
  val boundingBox: BoundingBox = BoundingBox(width, height)
