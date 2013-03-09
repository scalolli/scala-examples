package org.hashgeek.patterns

/**
 * Created with IntelliJ IDEA.
 * User: basu
 * Date: 3/7/13
 * Time: 10:24 PM
 */
object PatternsRunner {

  def main(args: Array[String]) {
    val t1 = (1,2)

    t1 match {
      case (1,x) => println(x)
      case _ => println("Nothing")
    }

    val s = "Basu"
    val m = Map[String, String]("1"-> "One", "2"->"Two")

    println("Output when sent string: " + convertToString(s))
    println("Output when sent a map: " + convertToString(m))

    trait Club

    trait Nameable {
      def name:String
    }

    sealed abstract class FootballClub extends Club with Nameable

    case class Chelsea(name:String)
    case class Arsenal(name:String)
    case class ManChesterUnited(name:String)

    val c = Chelsea("Lampard")
    val a = Arsenal("RVP")

    def clubMvP(club:Any) : String = (club : @unchecked) match {
      case x:Chelsea => "I love this club !!"
      case y:Arsenal => "Passing game amazing"
    }

    val partialFunctions: Any => String = {
      case Chelsea("Lampard") => "We rock"
      case _ => "I love football"
    }

    val f = partialFunctions(c)
    println(f)
    println(c)
  }


  def convertToString(x:Any) :String =
    x match {
      case s:String if s.length > 5 => s
      case m:Map[_,_] => m.keys.foldLeft("")((t1,t2)=> t1+" " +t2)
      case _ => ""
  }

  def higherOrder(f : (Int) => Boolean) : Boolean = {
      true
  }
}
