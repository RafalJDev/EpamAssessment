package controller;

import console.ConsoleReader;
import file.Reader;
import movies.MovieFinder;
import movies.movie.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaszczynski.Rafal on 26.03.2018.
 */
public class Controller {

  private List<Movie> movieList;
  String arg;
  String command;
  ConsoleReader consoleReader;

  public Controller(String arg) {
    this.arg = arg;
    movieList = new ArrayList<Movie>();
    consoleReader = new ConsoleReader();
  }

  public void runParser() {
    getAllMovies();

    while (command != "exit") {
      getCommand();
    }
  }

  public void getAllMovies() {
    Reader reader = new Reader(arg);

    List<String> linesList = reader.readTxtFile();

    MovieFinder mpc = new MovieFinder();

    for (String line : linesList) {
      Movie movie = mpc.searchForMovieWithRegex(line);
      if (movie != null) {
        movieList.add(movie);
      }
    }
  }

  public void getCommand() {
    command = consoleReader.readCommand();
  }
}
