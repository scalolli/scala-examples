package org.hashgeek.lists

import org.hashgeek.Hello._

/**
 * Created with IntelliJ IDEA.
 * User: basu
 * Date: 3/9/13
 * Time: 11:08 AM
 */
object ListsRunner {

  def main(args: Array[String]) {
    val l = List(1,2,3)
    val l2 = 1::2::3::Nil
    val List(a,b,c) = l

    l match {
      case x :: y :: xs => print("Head is: " + x) ;print("Head is: " + y); printRest(xs)
      case _ => print(l)
    }

    val l3 = l:::l2

    val flatExample = List(List(1), List(2), List(3))
    println(s"Flattened ${flatExample.flatten}")

    println(s"Zip ${l.zip(l2)}")

    val name = List('S', 'a', 'c', 'h', 'i', 'n')
    println(name.mkString(","))
    println(name.mkString("+",",", "stop"))

    val res = (l find (_ == 1)).getOrElse(2)
    println(s"result is: $res")
    println(s"result is: ${(l find (_ == 100)).getOrElse(2)}")
    p((List(1,2,3, -10, -20) takeWhile(_>0)))
    p((List(1,2,3, -10, -20) dropWhile (_>0)))

    p(("" /: "Basu".toList) (_ + " " + _))
    p((0 /: l)(_+_))
    p((1 /: l)(_*_))
    p((List[Int]() /: List(1,2,3))((x,y) => y::x))
    p((List(1,2,3) :\ List[Int]())((x,y)=> y:::List(x)))
    p(List.range(1,5))
    p(List.fill(5)('a'))
    p(List.fill(5,2)('a'))
    p(List.tabulate(3,3)((x,y) => x*y))

    val (l4,l5) = List((1,2),(3,4),(5,6)).unzip
    p(l4)
    p(l5)

    p((List(1,2,3), List(1,2)).zipped.map(_*_))
    val tup = ((List(1,2,3), List(1,2)).zipped)
  }

  def printRest(list:List[Int]) {
    list.foreach(print(_))
  }

  def append[T](xs:List[T], ys:List[T]) : List[T] = xs match {
    case List() => ys
    case x::xs1 => x :: append(xs1, ys)
  }
}
