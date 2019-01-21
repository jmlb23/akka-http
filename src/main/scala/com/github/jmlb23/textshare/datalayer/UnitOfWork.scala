package com.github.jmlb23.textshare.datalayer

import scala.util.Try

trait UnitOfWork extends AutoCloseable{

  def commit(): Try[Unit]
  def rollback(): Try[Unit]
}
