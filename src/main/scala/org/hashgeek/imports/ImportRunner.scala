package org.hashgeek.imports

import fruits.Fruits.{Apple => a, _}
import org.hashgeek.modifiers.Special
import org.hashgeek.traits.{DoublingQueue, BasicIntQueue, MixedQueue}

/**
 * Created with IntelliJ IDEA.
 * User: basu
 * Date: 3/3/13
 * Time: 11:26 PM
 * To change this template use File | Settings | File Templates.
 */
object ImportRunner {

  def main(args: Array[String]) {
    val mixQueue = new MixedQueue
    val basicQueue = new BasicIntQueue
    val doublingQueue = new DoublingQueue
    mixQueue.put(5)
    displayQueue(mixQueue)
    println("Color of apple is: " + a.color)
    val specialSub = new SpecialSubclass
    specialSub.hello()
  }

  def displayQueue(q: MixedQueue) {
    import q._
    println("Getting value from q: " + get())
  }

  class SpecialSubclass extends Special
}
