/**
 * Created with IntelliJ IDEA.
 * User: basu
 * Date: 4/6/13
 * Time: 2:08 PM
 */
public class Runner {
    String name;

    public static void main(String[] args) {
        Runner r = new Runner();
        Inner inner = r.new Inner();
        StaticInnerClass staticInnerClass = new Runner.StaticInnerClass();
    }

    class Inner {
        private String mine;

        public String display() {
            return name;
        }
    }

    static class  StaticInnerClass {

    }
}
