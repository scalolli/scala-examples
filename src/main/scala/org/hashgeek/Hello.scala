package org.hashgeek

/**
 * Created with IntelliJ IDEA.
 * User: basu
 * Date: 3/3/13
 * Time: 9:19 PM
 * To change this template use File | Settings | File Templates.
 */
object Hello {

  val p = println(_ : Any)

  def main(args: Array[String]) {
    println("Hello World !!!")
    p(calculate("Hello", 2))

    val l = List(1,2,3)
    p(l.drop(1))

    p(List(1,2,3) match {
      case Nil => "Empty"
      case x if x.length == 3 => "Blaah ..."
      case _ =>
    })

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

    p("m map g map f ≡ m flatMap {x => unit(g(x))} flatMap {y => unit(f(y))} " + l.flatMap(x => unit(multiplyBy2(x))) flatMap(y => unit(multiplyBy2(y))))
    p("m map g map f ≡ m flatMap {x => unit(g(x)) flatMap {y => unit(f(y))}} " + l.flatMap(x => unit(multiplyBy2(x)) flatMap(y => unit(multiplyBy2(y)))))
    p("m map g map f ≡ m flatMap {x => unit(g(x))} map {y => f(y)} " + l.flatMap(x => unit(multiplyBy2(x))) map (y => multiplyBy2(y)))
    p("m map g map f ≡ m flatMap {x => unit(g(x)) map {y => f(y)}} " + l.flatMap(x => unit(multiplyBy2(x)) map (y => multiplyBy2(y))))
    p("m map g map f ≡ m flatMap {x => unit(f(g(x))} " + l.flatMap(x => unit(multiplyBy2(multiplyBy2(x)))))
    p(" m map g map f ≡ m map {x => f(g(x))} " + l.map(x => multiplyBy2(multiplyBy2(x))))

  }

  def calculate() : Tuple2[Int, String] = (2, "Ted")

  def calculate(msg:String, count:Int) : String = msg.take(count)

  def foo(f : (String => Boolean)) : String = if (f("Ted")) "Cool" else "Not Cool !!"

}
