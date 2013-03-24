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

    p(List(1,2,3) map (_ => "2"))

    p(List(1,2,3) flatMap(_ => List("2", "2")))

    p(List(1,2,3) flatMap(gen => (List("one","two") map((gen, _)))))

    p((List("Chelsea", "Manchester United", "Arsenal") groupBy(_.length)) get(7))

    p(List(1,2,6).reduceLeft((x,y) => x*y))

    (List(1,2,3,4,5,6) sliding(3)) foreach(println)

    (List(1,2,3,4,5,6,7) grouped (2)) foreach(println)

    (List(1,2,3,4,5,6,7) sliding  (2)) foreach(println)

    val slice1 = List(1,2,3,4)
    val slice2 = List(3,4)

    p(slice1 indexOfSlice slice2)
    p(slice1 lastIndexOfSlice slice2)

    p(Map(1->2,2->3)(4))
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
