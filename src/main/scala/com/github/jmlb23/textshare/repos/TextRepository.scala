package com.github.jmlb23.textshare.repos

import com.github.jmlb23.textshare.datasources.Datasource
import com.github.jmlb23.textshare.domain.Text

import scala.util.Try

final class TextRepository(override val datasource: Datasource[Text, Long]) extends Repositories[Text,Long](datasource) {


  override def add(t: Text): Try[Unit] = ???

  override def get(id: Long): Try[Text] = ???

  override def getAll: Try[Seq[Text]] = ???

  override def remove(id: Long): Try[Unit] = ???

  override def update(id: Long, e: Text): Try[Unit] = ???

  override def filter(predicate: Text => Boolean): Try[Seq[Text]] = ???

}
