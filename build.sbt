import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.7",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Scala Seed Project",
    libraryDependencies ++=
      akka_http ::
      akka_streams ::
        circe ::
        circeIntegration ::
        mysql  ::
        Nil
  )

scalacOptions ++= Seq("-Ypartial-unification")