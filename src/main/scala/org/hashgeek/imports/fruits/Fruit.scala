package org.hashgeek.imports.fruits

/**
 * Created with IntelliJ IDEA.
 * User: basu
 * Date: 3/3/13
 * Time: 11:33 PM
 * To change this template use File | Settings | File Templates.
 */
abstract class Fruit(val name: String, val color: String)


object Fruits {

  object Apple extends Fruit("apple", "red")

  object Orange extends Fruit("orange", "orange")

  val list = List(Apple, Orange)

}