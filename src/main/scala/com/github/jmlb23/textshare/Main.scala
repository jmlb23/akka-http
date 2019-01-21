package com.github.jmlb23.textshare

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.github.jmlb23.textshare.services.Services

object Main {
  implicit val actorSystem = ActorSystem("http")
  implicit val actorMaterializer = ActorMaterializer()
  def main(args: Array[String]): Unit = {
    Http().bindAndHandle(Services.routes, "localhost",8080)
  }
}
