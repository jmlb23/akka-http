package com.github.jmlb23.textshare.repos

import com.github.jmlb23.textshare.datasources.Datasource

import scala.util.Try

abstract class Repositories[E <: Product,I](val datasource: Datasource[E,I]) {
  def add(t: E): Try[Unit]
  def get(id: Long): Try[E]
  def getAll: Try[Seq[E]]
  def remove(id: Long): Try[Unit]
  def update(id: Long, e: E): Try[Unit]
  def filter(predicate : E => Boolean) : Try[Seq[E]]
}
