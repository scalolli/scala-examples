package org.hashgeek.parameterization.contravariance


/**
 * Created with IntelliJ IDEA.
 * User: basu
 * Date: 3/11/13
 * Time: 11:15 PM
 */
object ContravarianceRunner {

  def main(args: Array[String]) {
    def getTitle(p: Publication): String = p.title
    def getTitle2(p:Magazine) : String = p.title

    printBookList(getTitle) //works because getTitle is a sub type
//    printBookList(getTitle2) //I know function parameters are contravariant but what will happen if this were to work?
  }

  class Publication(val title: String)
  class Book(title: String) extends Publication(title)
  class Magazine(title:String, author:String) extends Book(title)

    val books: Set[Book] =
      Set(
        new Book("Programming in Scala"),
        new Book("Walden")
      )
    def printBookList(info: Book => AnyRef) {
      for (book <- books) println(info(book))
    }

}
