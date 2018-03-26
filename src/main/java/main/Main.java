package main;

import console.ConsoleReader;
import controller.Controller;
import file.Reader;
import movies.MovieFinder;
import movies.movie.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaszczynski.Rafal on 27.02.2018.
 */
public class Main {

  public static void main(String[] args) {

    Controller controller = new Controller(args[0]);
    controller.runParser();
  }
}
