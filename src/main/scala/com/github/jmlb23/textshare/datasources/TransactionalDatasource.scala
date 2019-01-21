package com.github.jmlb23.textshare.datasources

import scala.util.Try

trait TransactionalDatasource[E <: Product,I] extends Datasource[E,I]{

  def commit: Try[Unit]
  def rollback: Try[Unit]
}
