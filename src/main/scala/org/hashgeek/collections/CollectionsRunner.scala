package org.hashgeek.collections

import collection.mutable.{ArrayBuffer, ListBuffer}
import org.hashgeek.Hello.p
import collection.mutable
import collection.immutable.{SortedMap, TreeSet}

/**
 * Created with IntelliJ IDEA.
 * User: basu
 * Date: 3/9/13
 * Time: 9:31 PM
 */
object CollectionsRunner {

  def main(args: Array[String]) {
    val lb = ListBuffer[String]()
    lb.+=("Basu")
    lb.+=:("Jet")
    p(lb.toList)

    val arrBuffer = ArrayBuffer[Int](1,2,3)
    arrBuffer += 1
    arrBuffer.+=:(2)
    arrBuffer.remove(0,1)
    p(arrBuffer)

    val s = mutable.Set.empty[String]

    s += "Basu"
    s += "Basu"
    s += "Jet"

    s.remove("Basu")

    p(s)

    val m = mutable.Map.empty[Int, String]

    m(1) = "Basu"
    m(2) = "Jet"

    p(m(1))

    count("basu basu chelsea chelsea arsenal football")

    val sortedSet = TreeSet(4,5,6,1)
    p(sortedSet)
    p(SortedMap(5->"Five", -1->"MinusOne", 10->"Ten"))
  }

  def count(value : String) {
    val counts = mutable.Map.empty[String, Int]

    for (rawText <- value.split("[ ,!.]+")) {
      val word = rawText
      val cnt = if (counts.contains(word)) counts(word) else 0
      counts += (word -> (cnt+1))
    }

    p(counts)
  }
}
