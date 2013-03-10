package org.hashgeek.parameterization.books

/**
 * Created with IntelliJ IDEA.
 * User: basu
 * Date: 3/10/13
 * Time: 5:30 PM
 */
class Book private (private val name:String, private val author :String) {

}

object Book {
  def apply(name:String, author:String) : Book = new Book(name, author)
}
