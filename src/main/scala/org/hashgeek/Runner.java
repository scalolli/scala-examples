package org.hashgeek;

/**
 * Created with IntelliJ IDEA.
 * User: basu
 * Date: 3/12/13
 * Time: 11:34 PM
 */
public class Runner {

    public static void main(String[] args) {
        tryContravariance(new SubDerived());
    }

    class Base {

    }

    class Derived extends Base {

    }

    static class SubDerived extends Derived {

    }

    private static Object tryContravariance(Derived d) {
        return "abc";
    }


}
