package org.hashgeek.traits

/**
 * Created with IntelliJ IDEA.
 * User: basu
 * Date: 3/3/13
 * Time: 9:22 PM
 * To change this template use File | Settings | File Templates.
 */
object TraitsRunner {

  def main(args: Array[String]) {
    val phil : Philosophical = new Frog
    phil.philosophize()
  }

  class Animal

  trait Philosophical {
    def philosophize() {
      println("I consume memory therefore I am")
    }
  }

  trait HasLegs

  class Frog extends Animal with Philosophical with HasLegs {

    override def philosophize() {
      println("It ain't easy being green")
    }

    override def toString: String = "green"
  }

}
