package main;

import controller.Controller;

/**
 * Created by Jaszczynski.Rafal on 27.02.2018.
 */
public class Main {

  public static void main(String[] args) {

    System.out.println("Print " + System.getProperty("user.dir"));

    Controller controller = new Controller(args[0]);
    controller.runParser();
  }
}
