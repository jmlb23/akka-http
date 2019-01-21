package com.github.jmlb23.textshare.datasources
import scala.util.Try

class InMemoryDataSource[E <: Product, I] extends Datasource[E,I] {
  val mock = scala.collection.mutable.Set[E]()

  def addElements(e: E*) = mock ++= e

  override def insert(e: E): Try[Unit] = Try{
    mock.add(e)
  }

  override def update(pred: E => Boolean, e: E): Try[Unit] = Try{
    val toDelete = mock.takeWhile(pred)
    val toMap = toDelete.clone()
    toDelete.foreach(x => mock.remove(x))
    toMap.map(x => e).foreach(x => mock.add(x))
  }

  override def delete(pred: E => Boolean): Try[Unit] = Try{
    mock.takeWhile(pred).foreach(x => mock.remove(x))
  }

  override def select(pred: E => Boolean): Try[Seq[E]] = Try{
    mock.filter(pred).toSeq
  }

  override def close(): Unit = {}
}