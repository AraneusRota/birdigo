package violetempiregames.init

import indigo.{AssetPath, *}

object Assets:
  import violetempiregames.init.FontAssets._

  object Bird:
    val faceless: AssetName = AssetName("bird_faceless")
    val fall: AssetName = AssetName("bird_fall")
    val rise: AssetName = AssetName("bird_rise")
  val bird: Bird.type = Bird

  object Background:
    val albedo: AssetName = AssetName("background_albedo")
    val emission: AssetName = AssetName("background_emission")
    val normal: AssetName = AssetName("background_normal")
  val background: Background.type = Background

  object Obstacle:
    object Mid:
      val albedo: AssetName = AssetName("obstacle_mid_albedo")
      val emission: AssetName = AssetName("obstacle_mid_emission")
      val normal: AssetName = AssetName("obstacle_mid_normal")
    val mid: Mid.type = Mid

    val end: AssetName = AssetName("obstacle_end")
  val obstacle: Obstacle.type = Obstacle

  val assets: Set[AssetType] = Set(
    AssetType.Image(fontName, assetPathPng("boxy_font")),
    AssetType.Image(bird.faceless, assetPathPng("bird/faceless")),
    AssetType.Image(bird.fall, assetPathPng("bird/fall")),
    AssetType.Image(bird.rise, assetPathPng("bird/rise")),
    AssetType.Image(obstacle.mid.albedo, assetPathPng("obstacle/mid/albedo")),
    AssetType.Image(obstacle.mid.emission, assetPathPng("obstacle/mid/emission")),
    AssetType.Image(obstacle.mid.normal, assetPathPng("obstacle/mid/normal")),
    AssetType.Image(obstacle.end, assetPathPng("obstacle/end")),
    AssetType.Image(background.albedo, assetPathPng("background/albedo_gray")),
    AssetType.Image(background.emission, assetPathPng("background/emission")),
    AssetType.Image(background.normal, assetPathPng("background/normal")),
  )

  def assetPath(pathWithoutPrefix: String): AssetPath = AssetPath("assets/" + pathWithoutPrefix)
  def assetPathPng(pathWithoutPrefixAndExtension: String): AssetPath =
    AssetPath("assets/" + pathWithoutPrefixAndExtension + ".png")
end Assets

object FontAssets:
    val fontName: AssetName = AssetName("Boxy font")

    def fontKey: FontKey = FontKey("My Font")

    val fontMaterial: Material.ImageEffects =
      Material.ImageEffects(fontName)

    def fontInfo: FontInfo =
      FontInfo(fontKey, 320, 230, FontChar("?", 93, 52, 23, 23))
        .addChar(FontChar("A", 3, 78, 23, 23))
        .addChar(FontChar("B", 26, 78, 23, 23))
        .addChar(FontChar("C", 50, 78, 23, 23))
        .addChar(FontChar("D", 73, 78, 23, 23))
        .addChar(FontChar("E", 96, 78, 23, 23))
        .addChar(FontChar("F", 119, 78, 23, 23))
        .addChar(FontChar("G", 142, 78, 23, 23))
        .addChar(FontChar("H", 165, 78, 23, 23))
        .addChar(FontChar("I", 188, 78, 15, 23))
        .addChar(FontChar("J", 202, 78, 23, 23))
        .addChar(FontChar("K", 225, 78, 23, 23))
        .addChar(FontChar("L", 248, 78, 23, 23))
        .addChar(FontChar("M", 271, 78, 23, 23))
        .addChar(FontChar("N", 3, 104, 23, 23))
        .addChar(FontChar("O", 29, 104, 23, 23))
        .addChar(FontChar("P", 54, 104, 23, 23))
        .addChar(FontChar("Q", 75, 104, 23, 23))
        .addChar(FontChar("R", 101, 104, 23, 23))
        .addChar(FontChar("S", 124, 104, 23, 23))
        .addChar(FontChar("T", 148, 104, 23, 23))
        .addChar(FontChar("U", 173, 104, 23, 23))
        .addChar(FontChar("V", 197, 104, 23, 23))
        .addChar(FontChar("W", 220, 104, 23, 23))
        .addChar(FontChar("X", 248, 104, 23, 23))
        .addChar(FontChar("Y", 271, 104, 23, 23))
        .addChar(FontChar("Z", 297, 104, 23, 23))
        .addChar(FontChar("0", 3, 26, 23, 23))
        .addChar(FontChar("1", 26, 26, 15, 23))
        .addChar(FontChar("2", 41, 26, 23, 23))
        .addChar(FontChar("3", 64, 26, 23, 23))
        .addChar(FontChar("4", 87, 26, 23, 23))
        .addChar(FontChar("5", 110, 26, 23, 23))
        .addChar(FontChar("6", 133, 26, 23, 23))
        .addChar(FontChar("7", 156, 26, 23, 23))
        .addChar(FontChar("8", 179, 26, 23, 23))
        .addChar(FontChar("9", 202, 26, 23, 23))
        .addChar(FontChar("?", 93, 52, 23, 23))
        .addChar(FontChar("!", 3, 0, 15, 23))
        .addChar(FontChar(".", 286, 0, 15, 23))
        .addChar(FontChar(",", 248, 0, 15, 23))
        .addChar(FontChar(" ", 145, 52, 23, 23))