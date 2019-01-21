package com.github.jmlb23.textshare.services

import java.time.LocalDateTime

import akka.actor.ActorSystem
import akka.http.javadsl.model.HttpEntities
import akka.http.scaladsl.model.ContentType.WithCharset
import akka.http.scaladsl.model.{ContentType, ContentTypes, HttpEntity, MediaTypes}
import akka.http.scaladsl.model.headers.HttpEncodings
import com.github.jmlb23.textshare.datasources.InMemoryDataSource
import com.github.jmlb23.textshare.domain.User
import com.github.jmlb23.textshare.repos.UserRepository
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
import io.circe.generic.auto._
import io.circe.syntax._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.directives.HeaderDirectives

object Services {

  class Request(val payload: User)

  val userRepo = new UserRepository(new InMemoryDataSource[User, Long] {
    addElements(User(id = 1, username = "jesus", LocalDateTime.now(), Nil))
  })


  val routes =
    get {
      path("users") {
        complete(HttpEntity(ContentType(MediaTypes.`application/json`.withParams(Map("charset" -> "UTF-8"))), userRepo.getAll.fold(e => s"""{ "errors": ${e.getMessage}}""", s => s"""{ "data": ${s.asJson.spaces4}}""")))
      }
    } ~
      post {
        path("users") {
          entity(as[Request]) { user =>
            complete(HttpEntity(ContentType(MediaTypes.`application/json`.withParams(Map("charset" -> "UTF-8"))), userRepo.add(user.payload).fold(e =>s"""{ "errors": ${e.getMessage}""", s => s"""{ "data": { "message": "success"}""")))
          }
        }
      } ~
      get {
        path("users" / IntNumber) { id =>
          complete(HttpEntity(ContentType(MediaTypes.`application/json`.withParams(Map("charset" -> "UTF-8"))), userRepo.get(id).fold(e => s"""{ "errors": "not found"}""", s => s"""{ "data": ${s.asJson.spaces4}}""")))
        }
      } ~
      delete {
        path("users" / IntNumber) { id =>
          complete(HttpEntity(ContentType(MediaTypes.`application/json`.withParams(Map("charset" -> "UTF-8"))), userRepo.remove(id).fold(e => s"""{ "errors": "not found"}""", s => s"""{ "data": "remove with success"}""")))
        }
      } ~
      put {
        path("users" / IntNumber) { id =>
          entity(as[Request]){ req =>
            complete(HttpEntity(ContentType(MediaTypes.`application/json`.withParams(Map("charset" -> "UTF-8"))), userRepo.update(id,req.payload).fold(e => s"""{ "errors": "not found"}""", s => s"""{ "data": "update with success"}""")))
          }
        }
      }
}
