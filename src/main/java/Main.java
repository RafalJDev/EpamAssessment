import test.TestClass;

/**
 * Created by Jaszczynski.Rafal on 27.02.2018.
 */
public class Main {

  public static void main(String[] args) {
    System.out.println("say hello from here");

    TestClass testClass = new TestClass();
    testClass.saySth();

    testMe();
  }

  public static void testMe() {
    System.out.println("next test");
  }

}
