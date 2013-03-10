package org.hashgeek.parameterization.company

/**
 * Created with IntelliJ IDEA.
 * User: basu
 * Date: 3/10/13
 * Time: 6:46 PM
 */
object CompanyExampleRunner {
  def main(args: Array[String]) {
    val bigCompany = new BigCompany
    val smallCompany = new SmallCompany
    val thirdCompany = new Startup

    val bigCompanyManufacturingUnit = new ManufacturingUnit[BigCompany]
    val smallCompanyManufacturingUnit = new ManufacturingUnit[SmallCompany]
    val startupCompanyManufacturingUnit = new ManufacturingUnit[Startup]

    manufacture(smallCompanyManufacturingUnit)

    bigCompanyManufacturingUnit.partnerWithAcceptsAnyRef(bigCompanyManufacturingUnit)
    bigCompanyManufacturingUnit.partnerWithAcceptsAnyRef(smallCompanyManufacturingUnit)
    bigCompanyManufacturingUnit.partnerWithAcceptsAnyRef(startupCompanyManufacturingUnit)

    smallCompanyManufacturingUnit.partnerWithAcceptsAnyRef(bigCompanyManufacturingUnit)
    smallCompanyManufacturingUnit.partnerWithAcceptsAnyRef(smallCompanyManufacturingUnit)

    bigCompanyManufacturingUnit.partnerWithAcceptsOnlySubClassBigCompany(smallCompanyManufacturingUnit)
    bigCompanyManufacturingUnit.partnerWithAcceptsOnlySubClassSmallCompany(startupCompanyManufacturingUnit)
    bigCompanyManufacturingUnit.partnerWithAcceptsOnlySubClassBigCompany(startupCompanyManufacturingUnit)
    bigCompanyManufacturingUnit.partnerWithAcceptsAnyRef(new CrapCompany)
  }

  class ManufacturingUnit[+T]() {

    /**
     * Takes anything that can become the super type i.e AnyRef now I understand this fully because of the excellent
     * stackoverflow article
     *
     * http://stackoverflow.com/questions/9835651/about-lower-bound-in-scala
     *
     * What you said that specifically U should be a super-type of T (or T).
     * This means Another works great because ScalaObject is the most specific super-type of both Another and Fruit.
     *
     * Imagine the colon >: as an equals >=
     *
     * @param partner
     * @tparam U
     */
    def partnerWithAcceptsAnyRef[U >: ManufacturingUnit[T]](partner: U) {


    }

    /**
     * Takes BigCompany, SmallCompany and Startup manufacturing unit
     * @param partner
     * @tparam U
     */
    def partnerWithAcceptsOnlySubClassBigCompany[U <: ManufacturingUnit[BigCompany]](partner:U) {

    }

    /**
     * Takes only startup and small company manufacturing unit
     * @param partner
     * @tparam U
     */
    def partnerWithAcceptsOnlySubClassSmallCompany[U <: ManufacturingUnit[SmallCompany]](partner:U) {

    }
  }

  class BigCompany

  class SmallCompany extends BigCompany

  class Startup extends SmallCompany

  class CrapCompany

  def manufacture(unit: ManufacturingUnit[BigCompany]): Int = {
    3
  }
}
