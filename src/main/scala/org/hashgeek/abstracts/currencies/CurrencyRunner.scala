package org.hashgeek.abstracts.currencies

/**
 * Created with IntelliJ IDEA.
 * User: basu
 * Date: 3/16/13
 * Time: 6:54 PM
 */
object CurrencyRunner {
  def main(args: Array[String]) {

  }

  abstract class CurrencyZone {
    type Currency <: AbstractCurrency
    def make(x : Long) : Currency

    abstract class AbstractCurrency {
      val amount : Long
      val designation : String
      def + (that : Currency) : Currency = make(this.amount + that.amount)
      override def toString: String = s"$amount $designation"
    }
  }

  object US extends CurrencyZone {
    abstract class Dollar extends AbstractCurrency {
      val designation: String = "USD"
    }
    type Currency = Dollar

    def make(x: Long): US.Currency = new Dollar {
      val amount: Long = x
    }
  }

  object India extends CurrencyZone {
    abstract class Rupee extends AbstractCurrency {
      val designation: String = "Rs."
    }

    type Currency = Rupee

    def make(x: Long): India.Currency = new Rupee {
      val amount: Long = x
    }
  }
}
