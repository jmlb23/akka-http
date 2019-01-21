package com.github.jmlb23.textshare.repos

import com.github.jmlb23.textshare.datasources.Datasource
import com.github.jmlb23.textshare.domain.User

import scala.util.Try

final class UserRepository(override val datasource: Datasource[User, Long]) extends Repositories[User,Long](datasource) {

  override def add(t: User): Try[Unit] = datasource.insert(t)

  override def get(id: Long): Try[User] = datasource.select(x => x.id == id).map(_.head)

  override def getAll: Try[Seq[User]] = datasource.select(x => 1 == 1)

  override def remove(id: Long): Try[Unit] = datasource.delete(x => x.id == id)

  override def update(id: Long, e: User): Try[Unit] = datasource.update(e => e.id == id, e)

  override def filter(predicate: User  => Boolean): Try[Seq[User]] = datasource.select(predicate)
}
