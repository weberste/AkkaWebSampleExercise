package org.chicagoscala.awse.persistence
import org.joda.time._
import org.joda.time.format._
import scala.math._
import scala.math.Ordering._
import net.liftweb.json.JsonAST._

/**
 * Trait for storage of time-oriented, JSON data, parameterized by the format used for date times in
 * queries.
 */
trait DataStore {

  def add(item: JSONRecord): Unit
  
  def addAll(items: Iterable[JSONRecord]): Unit = for (item <- items) add(item)
  
  def getAll(): Iterable[JSONRecord]
  
  def range(from: DateTime, to: DateTime, otherCriteria: JValue = JNothing, maxNum: Int = java.lang.Integer.MAX_VALUE): Iterable[JSONRecord]

  def getDistinctValuesFor(key: String): Iterable[JSONRecord]

  /** 
   * General interface to the query capabilities of the underlying persistent store. Requires that the
   * store (or support classes) can interpret the input Map as necessary. The supported queries are
   * store-dependent!
   */
  // def query(querySpecification: Map[String, Any]): Iterable[JSONRecord]

  def size: Long
}  
