package com.github.jmlb23.textshare.datalayer

import scala.util.Try

class UnitOfWorkJdbcMysql extends UnitOfWork {
  //val context =


  override def commit(): Try[Unit] = ???

  override def rollback(): Try[Unit] = ???

  override def close(): Unit = ???
}
