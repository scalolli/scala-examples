package org.hashgeek.traits

/**
 * Created with IntelliJ IDEA.
 * User: basu
 * Date: 3/3/13
 * Time: 9:39 PM
 * To change this template use File | Settings | File Templates.
 */
object GeometricRunner {

  def main(args: Array[String]) {
    val rect = new Rectangle(new Point(1,3), new Point(4,5))
    println("Width is: " + rect.width)

  }

  class Point(val x:Int, val y:Int)

  trait Rectangular {
    def topLeft : Point
    def bottomRight : Point

    def left = topLeft.x
    def right = bottomRight.x
    def width = right - left
  }

  abstract class Component extends Rectangular

  class Rectangle(val topLeft: Point, val bottomRight: Point) extends Rectangular

}
