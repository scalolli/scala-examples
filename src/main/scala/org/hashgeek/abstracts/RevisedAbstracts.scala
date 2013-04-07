package org.hashgeek.abstracts

/**
 * Created with IntelliJ IDEA.
 * User: basu
 * Date: 4/6/13
 * Time: 2:28 PM
 */
object RevisedAbstracts {

  def main(args: Array[String]) {
    val a = new Cow
    a.eat(new Grass)
    val pasture = new Pasture
    val l = (new Shark) :: pasture.animals
    val animal = l(0).asInstanceOf[Cow]
    animal.eat(new Grass)
  }

  abstract class Food

  abstract class Animal {
    type SuitableFood <: Food
    def eat(food:SuitableFood)
  }

  class Grass extends Food
  class Fish extends Food

  class Cow extends Animal {
    type SuitableFood = Grass
    def eat(food: Grass) {}
  }

  class Shark extends Animal {
    type SuitableFood = Fish

    def eat(food: Fish) {

    }
  }

  class Pasture {
    val animals = List[Animal {type SuitableFood = Grass}](new Cow)
  }
}
