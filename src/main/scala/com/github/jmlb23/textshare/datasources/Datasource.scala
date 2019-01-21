package com.github.jmlb23.textshare.datasources

import scala.util.Try

trait Datasource[E <: Product, I] extends AutoCloseable{
  def insert(e: E): Try[Unit]
  def update(pred: E => Boolean,e: E): Try[Unit]
  def delete(pred: E => Boolean): Try[Unit]
  def select(pred: E => Boolean): Try[Seq[E]]
}
