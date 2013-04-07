package org.hashgeek.parameterization.covariance

/**
 * Created with IntelliJ IDEA.
 * User: basu
 * Date: 4/6/13
 * Time: 10:38 PM
 */
object CovarianceRunner {
  def main(args: Array[String]) {
    val q = new Queue[Apple]
    val r: List[Fruit] = q.set(new Orange)
    val q2 = new Queue[String]
    val r2: List[Any] = q.set("abc")
  }

  class Fruit
  class Orange extends Fruit
  class Apple extends Fruit

  class Queue[+T] {
    val l = List[T]()

    def set[U>:T](v : U) : List[U] = {
       v :: l
    }

  }
}
