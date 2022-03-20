import scala.sys.process._
import scala.language.postfixOps

import sbtwelcome._

Global / onChangedBuildSource := ReloadOnSourceChanges

Test / scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }

ThisBuild / scalafixDependencies += "com.github.liancheng" %% "organize-imports" % "0.5.0"

lazy val mygame =
  (project in file("."))
    .enablePlugins(ScalaJSPlugin, SbtIndigo)
    .settings( // Normal SBT settings
      name         := "birdigo",
      version      := "0.0.1",
      scalaVersion := "3.1.1",
      organization := "violetempiregames",
      libraryDependencies ++= Seq(
        "org.scalameta" %%% "munit" % "0.7.29" % Test
      ),
      testFrameworks += new TestFramework("munit.Framework"),
      scalafixOnCompile  := false,
      semanticdbEnabled  := true,
      semanticdbVersion  := scalafixSemanticdb.revision,
    )
    .settings( // Indigo specific settings
      showCursor          := true,
      title               := "Birdigo",
      gameAssetsDirectory := "assets",
      windowStartWidth    := 640,
      windowStartHeight   := 640,
      libraryDependencies ++= Seq(
        "io.indigoengine" %%% "indigo-json-circe" % "0.12.1",
        "io.indigoengine" %%% "indigo"            % "0.12.1",
        "io.indigoengine" %%% "indigo-extras"     % "0.12.1"
      )
    )
    .settings(
      code := {
        val command = Seq("code", ".")
        val run = sys.props("os.name").toLowerCase match {
          case x if x contains "windows" => Seq("cmd", "/C") ++ command
          case _                         => command
        }
        run.!
      }
    )
    .settings(
      logo := "Birdigo (v" + version.value.toString + ")",
      usefulTasks := Seq(
        UsefulTask("", "runGame", "Run the game (requires Electron)"),
        UsefulTask("", "buildGame", "Build web version"),
        UsefulTask("", "runGameFull", "Run the fully optimised game (requires Electron)"),
        UsefulTask("", "buildGameFull", "Build the fully optimised web version"),
        UsefulTask("", "code", "Launch VSCode")
      ),
      logoColor        := scala.Console.MAGENTA,
      aliasColor       := scala.Console.BLUE,
      commandColor     := scala.Console.CYAN,
      descriptionColor := scala.Console.WHITE
    )
    .enablePlugins(GhpagesPlugin) // Website stuff
    .settings(
      siteSourceDirectory      := target.value / "indigoBuildFull",
      makeSite / includeFilter := "*",
      makeSite / excludeFilter := ".DS_Store",
      git.remoteRepo           := "git@github.com:araneusrota/birdigo.git",
      ghpagesNoJekyll          := true
    )



addCommandAlias("buildGame", ";compile;fastOptJS;indigoBuild")
addCommandAlias("buildGameFull", ";compile;fullOptJS;indigoBuildFull")
addCommandAlias("runGame", ";compile;fastOptJS;indigoRun")
addCommandAlias("runGameFull", ";compile;fullOptJS;indigoRunFull")

addCommandAlias(
  "publishGame",
  List(
    "buildGameFull",
    "makeSite",
    "ghpagesPushSite"
  ).mkString(";", ";", "")
)

lazy val code =
  taskKey[Unit]("Launch VSCode in the current directory")
