package org.hashgeek.implicits

import org.joda.time.LocalDate
import java.util.Date
import org.hashgeek.implicits.{Person => JavaPerson}
import org.hashgeek.implicits

/**
 * Created with IntelliJ IDEA.
 * User: basu
 * Date: 3/16/13
 * Time: 7:21 PM
 */
object ImplicitsRunner {

  implicit def convertToCaseClass(p: JavaPerson) : SuperMan = new SuperMan(p.getName, p.getId)

  implicit def convertListOfPersons(l:List[JavaPerson]) : List[SuperMan] = l map(convertToCaseClass(_))

  def main(args: Array[String]) {
    val javaPerson = new JavaPerson()
    javaPerson.setId("1")
    javaPerson.setName("Basu")
    printPerson(javaPerson)
    printPerson(new SuperMan("2", "Jude"))

    val listOfPersons = List(javaPerson)
    printListOfPersons(listOfPersons)

    implicit val superMan = new SuperMan("Basu", "2")

    javaPerson.fly()

    printPerson

    print(Option(javaPerson.getName).get)


    println(Some(Dev(Nil)) flatMap{
       x => haskell(x) flatMap {
        (y => linux(y) flatMap {
          (z => scala(z) map {
            java(_)
          })
        })
      }
    })
//
//    for {
//        w <- Option(new SuperMan("basu", "2"))
//        x <- haskell(w)
//        y <- linux(x)
//        z <- java(y)
//    } yield z match {
//      case z : SuperMan => "You are Awesome !!!"
//      case _ => "Fail, get out of here !!!"
//    }
  }

  class SuperMan(val name: String, id: String) {
    def fly() {
      println("Hell yeah I can fly !!!")
    }
  }

  def printPerson(implicit p: SuperMan) {
    println(p.name)
  }

  def printListOfPersons(l : List[SuperMan]) {
    l.foreach((p:SuperMan) => print(p.name))
  }

  case class Dev(skills:List[String])

  def haskell(p: Dev) : Option[Dev] = Some(Dev("Haskell" :: p.skills))

  def scala(p: Dev) : Option[Dev] = Some(Dev("Scala" :: p.skills))

  def linux(p: Dev) : Option[Dev] = Some(Dev("Linux" :: p.skills))

  def java(p: Dev) : Dev = Dev("Java" :: p.skills)


}
