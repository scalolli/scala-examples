package org.hashgeek.statefulobjects

import org.hashgeek.statefulobjects.books.Book
import publishers.Publisher

/**
 * Created with IntelliJ IDEA.
 * User: basu
 * Date: 3/10/13
 * Time: 4:00 PM
 */
object StatefulRunner {

  def main(args: Array[String]) {
    val book = new Book()
    book.author = "Basu"
    book.name = "Scala"

    val publisher = new Publisher
    publisher.name = "Artima"
    publisher.address = "U.S"
  }

}

package books {
  class Book {
    var name :String = _
    var author: String = _
  }
}


