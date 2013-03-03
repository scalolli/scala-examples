package org.hashgeek.traits

import collection.mutable.ArrayBuffer

/**
 * Created with IntelliJ IDEA.
 * User: basu
 * Date: 3/3/13
 * Time: 9:54 PM
 * To change this template use File | Settings | File Templates.
 */
object QueueRunner {

  def main(args: Array[String]) {
    val doubleQueue = new DoublingQueue
    doubleQueue.put(2)
    doubleQueue.put(10)
    println("Pop first element: " + doubleQueue.get())

    val filteringQueue = new BasicIntQueue with Filtering {
      def filter(x: Int): Boolean = x > 0
    }
    filteringQueue.put(-3)
    filteringQueue.put(2)
    println("First element is: " + filteringQueue.get())
  }

  abstract class IntQueue {
    def get() : Int
    def put(x:Int)
  }

  trait Doubling extends IntQueue {
    abstract override def put(x:Int) {super.put(2*x)}
  }

  trait Incrementing extends IntQueue {
    abstract override def put(x:Int) {super.put(x+1)}
  }

  trait Filtering extends IntQueue {
    def filter(x:Int) : Boolean
    abstract override def put(x:Int) {if (filter(x)) super.put(x)}
  }

  class BasicIntQueue extends IntQueue {
    private val buf = new ArrayBuffer[Int]

    def get(): Int = buf.remove(0)

    def put(x:Int) {
      buf += x
    }
  }

  class DoublingQueue extends BasicIntQueue with Doubling

}
