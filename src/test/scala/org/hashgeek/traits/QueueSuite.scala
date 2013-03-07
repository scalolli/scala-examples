package org.hashgeek.traits

import org.scalatest.FunSuite

/**
 * Created with IntelliJ IDEA.
 * User: basu
 * Date: 3/4/13
 * Time: 11:02 PM
 * To change this template use File | Settings | File Templates.
 */
class QueueSuite extends FunSuite {

  test("test incrementing queue") {
    val q = new BasicIntQueue with Incrementing
    q.put(1)
    q.put(5)
    assert(2 === q.get())
  }

  test("test filtering queue") {
    val q = new BasicIntQueue with Filtering {
      def filter(x: Int): Boolean = x > 0
    }
    q.put(-1)
    q.put(5)
    expect(5) {
      q.get()
    }
  }

}
