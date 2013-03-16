package org.hashgeek.abstracts

import java.io.PrintWriter

/**
 * Created with IntelliJ IDEA.
 * User: basu
 * Date: 3/16/13
 * Time: 10:00 AM
 */
object AbstractsRunner {

  lazy val favouriteClubName : String = {
    println("Am here")
   "Chelsea"
  }

  object CarType extends Enumeration {
    val SEDAN, HATCHBACK, SUV = Value
  }

  def main(args: Array[String]) {
    val c = new {
      val name = "Chelsea"
    } with AbstractFootballClub
    println(favouriteClubName)
    println(favouriteClubName)
    val animal = new Cow
    animal.eat(new animal.T)
    close(new Window)
    close(new BankAccount)
  }

  trait AbstractTraitExample {
    type T
    def transform(x:T)
    def initial : T
    def current : T
  }

  class ConcreteTrait extends AbstractTraitExample {
    type T = String
    def transform(x: ConcreteTrait#T) {}
    def initial: ConcreteTrait#T = "Basu"
    def current: ConcreteTrait#T = initial
  }

  trait AbstractFootballClub {
    val name : String
    require(name == "Chelsea")
  }

  class Chelsea extends {
    val name = "Chelsea"
  } with AbstractFootballClub

  class Food
  class Grass extends Food
  class Fish extends Food

  trait Animal {
    type T <: Food
    def eat(f : T)
  }

  class Cow extends Animal {
    type T = Grass
    override def eat(f: Grass) {}
  }

  class BankAccount extends AutoCloseable {
    def close() {}
  }

  class Window extends AutoCloseable {
    def close() {}
  }

  def close[T <: {def close()}](resource : T) {
    resource.close()
  }

}
