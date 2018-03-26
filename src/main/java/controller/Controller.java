package controller;

import commands.Command;
import commands.CommandFactory;
import console.ConsoleReader;
import file.Reader;
import movies.MovieFinder;
import movies.movie.Movie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaszczynski.Rafal on 26.03.2018.
 */
public class Controller {

  private List<Movie> movieList;
  private List<Movie> filteredMovieList;
  String arg;
  String command;
  String consoleArgument;
  ConsoleReader consoleReader;
  Command commandToExecute;

  public Controller(String arg) {
    this.arg = arg;
    movieList = new ArrayList<Movie>();
    consoleReader = new ConsoleReader();
  }

  public void runParser() {
    getAllMovies();


    boolean exit = false;
    while (exit == false) {
      if (filteredMovieList == null) {
        filteredMovieList = movieList;
      }
      getCommand();

      prepareCommand();

      executeCommand();

      if (command.equals("exit")) {
        exit = true;
      }
    }

    System.out.println("Exit program");
    System.exit(0);
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
    String line = null;
    try {
      line = consoleReader.readCommand().trim();
    } catch (IOException e) {
      System.out.println("Something wrong with command line");
      e.printStackTrace();
    }
    String[] arguments = line.split(" ");


    command = arguments[0];

    if (arguments.length == 2) {
      consoleArgument = arguments[1];
    } else {
      consoleArgument = null;
    }
  }

  public void prepareCommand() {
    commandToExecute = CommandFactory.getCommand(command);
  }

  public void executeCommand() {
    if (commandToExecute != null) {
      filteredMovieList = commandToExecute.execute(filteredMovieList, consoleArgument);
    }
  }
}
