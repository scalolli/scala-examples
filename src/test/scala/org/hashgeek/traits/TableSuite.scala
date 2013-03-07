package org.hashgeek.traits

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.FunSuite

/**
 * Created with IntelliJ IDEA.
 * User: basu
 * Date: 3/5/13
 * Time: 1:34 AM
 */
class TableSuite extends FunSuite with TableDrivenPropertyChecks {

  test("test with large table values") {
    val values = Table(
      ("param1", "param2"),
      (2,2),(5,6)
    )
    forAll(values) {
      (param1, param2) => assert(param1 == param2)
    }
  }

}
