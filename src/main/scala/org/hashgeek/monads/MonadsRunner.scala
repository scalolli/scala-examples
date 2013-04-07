package org.hashgeek.monads

import org.hashgeek.Hello.p
import org.specs2.internal.scalaz.std.OptionOrder

/**
 * Created with IntelliJ IDEA.
 * User: basu
 * Date: 3/24/13
 * Time: 2:54 PM
 */
object MonadsRunner {
  def main(args: Array[String]) {

    val l = List(1,2,3)

    //The Functor/Monad Connection Law: The Zeroth Law
    p(l map (_*2))
    p(l flatMap(x => List(x*2)))

    //Flatten revisited
    val identity = (x:Int) => List(x)
    p(s"Flatmap: ${l.flatMap(identity)}")
    p(s"Flattening: ${l.map(identity).flatten}")

    // The First Monad Law: Identity flatMap undoes whatever unit does
    p(s"First Monad law: ${l.flatMap(identity)}")

    // Second Monad Law : Unit
    val f = (x:Int) => x*x
    p(s"Unit law using flatmap: ${List(2).flatMap(x=>identity(f(x)))}")
    p(s"Unit law using f(x): ${List(f(2))}")

    //Third law of Monads Composition
    val multiplyBy2 = (x:Int) => 2*x
    def unit(x:Int) = List(x)

    p("m map g map f ≡ m flatMap {x => unit(g(x))} flatMap {y => unit(f(y))} " + (l.flatMap(x => unit(multiplyBy2(x))) flatMap(y => unit(multiplyBy2(y)))))
    p("m map g map f ≡ m flatMap {x => unit(g(x)) flatMap {y => unit(f(y))}} " + (l.flatMap(x => unit(multiplyBy2(x)) flatMap(y => unit(multiplyBy2(y))))))
    p("m map g map f ≡ m flatMap {x => unit(g(x))} map {y => f(y)} " + (l.flatMap(x => unit(multiplyBy2(x))) map (y => multiplyBy2(y))))
    p("m map g map f ≡ m flatMap {x => unit(g(x)) map {y => f(y)}} " + (l.flatMap(x => unit(multiplyBy2(x)) map (y => multiplyBy2(y)))))
    p("m map g map f ≡ m flatMap {x => unit(f(g(x))} " + l.flatMap(x => unit(multiplyBy2(multiplyBy2(x)))))
    p(" m map g map f ≡ m map {x => f(g(x))} " + l.map(x => multiplyBy2(multiplyBy2(x))))

    val list = List("India", "Japan", "France", "Russia")
    val capitals = Map("India"->"New Delhi", "Japan"->"Tokyo")

    p(list flatMap (i => capitals.get(i) map(j => j)))
    p(list flatMap(((country:String) => capitals.get(country) map (y => y))))


    val o = Some(Order(101))

  }

  case class Order(value:Int)

  def creditCheck(order : Order) : Option[Order] = Some(order)

  def greaterThanCheck(order : Order) : Option[Order] = if (order.value > 100) Some(order) else None


}
