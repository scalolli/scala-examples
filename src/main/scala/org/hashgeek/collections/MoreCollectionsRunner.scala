package org.hashgeek.collections

import collection.mutable.{ListBuffer, ArrayBuffer}
import collection.mutable

/**
 * Created with IntelliJ IDEA.
 * User: basu
 * Date: 3/17/13
 * Time: 9:33 PM
 */
object MoreCollectionsRunner {
  def main(args: Array[String]) {
    val l = 1 #:: 2 #:: Stream.empty

    val v = Vector(1,2,3)

    println(v)
    println(1 to 10 by 3)

    val arrBuffer = ArrayBuffer.empty[Int] //imp: Note how the array buffer is constructed using ArrayBuffer.empty[String]
    arrBuffer += 1
    arrBuffer +=2
    arrBuffer(0) = 100
    println("Array buffer: " + arrBuffer)
    println(s"Now converting array buffer to an array: ${arrBuffer.toArray.mkString(", ")}")

    val listBuffer = ListBuffer.empty[String]
    listBuffer += "Chelsea"
    listBuffer += "Machester United"
    listBuffer += "Arsenal"
    println(s"Top english clubs: $listBuffer")
    println(s"Converting list buffer to an array: ${listBuffer.toList}")

    val strBuilder = new mutable.StringBuilder
    strBuilder += 'a'
    strBuilder ++= "abcdef" //imp: Note the use ++= operator when adding a sequence of characters
    println(s"Building a string using string builder $strBuilder")

    val map = mutable.HashMap.empty[Int, String]
    map += (1->"One")
    map += (2->"Two")
    println(s"Hash map contents are $map")

    val viewExample = ((List(1,2,3,4,5).view map(_+2)) map (_*3)).force
    print(s"Construct v using view and force: $viewExample}")


  }
}
