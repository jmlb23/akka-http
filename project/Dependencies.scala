import sbt._

object Dependencies {
  val circeVersion = "0.9.0"
  lazy val akka_http = "com.typesafe.akka" %% "akka-http"   % "10.1.7"
  lazy val akka_streams = "com.typesafe.akka" %% "akka-stream" % "2.5.19"
  lazy val circe = "io.circe" %% "circe-generic" % circeVersion
  lazy val mysql = "mysql" % "mysql-connector-java" % "8.0.13"
  lazy val circeIntegration = "de.heikoseeberger" %% "akka-http-circe" % "1.24.3"
}
