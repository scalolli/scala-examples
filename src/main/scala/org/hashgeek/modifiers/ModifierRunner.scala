package org.hashgeek.modifiers

import org.hashgeek.imports.fruits._

/**
 * Created with IntelliJ IDEA.
 * User: basu
 * Date: 3/3/13
 * Time: 11:51 PM
 * To change this template use File | Settings | File Templates.
 */
object ModifierRunner {

  def main(args: Array[String]) {
    val sub = new Sub
    val special = new Special
    helloFruits()
  }

  private[ModifierRunner] class Super {
    protected def display() {
      print("Hello")
    }
  }

  protected[modifiers] class Sub extends Super {
    display()
  }

}

protected[modifiers] class Special {
  def hello() {
    println("Hello from special class")
  }
}


class Rocket {
  private def display() {
    println("I am the rocket !!!")
    Rocket.name
  }
}

object Rocket {
  def main(args: Array[String]) {
    (new Rocket()).display()
  }

  def name = "Rocket"
}


