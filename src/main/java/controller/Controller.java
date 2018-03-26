package controller;

import commands.Command;
import commands.CommandFactory;
import console.ConsoleReader;
import file.Reader;
import movies.MovieFinder;
import movies.movie.Movie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jaszczynski.Rafal on 26.03.2018.
 */
public class Controller {

  private List<Movie> movieList;
  private List<Movie> filteredMovieList;
  String arg;
  String command = "";
  String commandArgument;
  ConsoleReader consoleReader;
  Command commandToExecute;

  Map<String, String> consoleArguments;

  public Controller(String arg) {
    this.arg = arg;
    movieList = new ArrayList<>();
    consoleReader = new ConsoleReader();
  }

  public void runParser() {
    getAllMovies();

    boolean exit = false;
    while (exit == false) {
      if (filteredMovieList == null) {
        filteredMovieList = movieList;
      }
      getCommands();

      for (Map.Entry<String, String> consoleArgument : consoleArguments.entrySet()) {
        command = consoleArgument.getKey();
        commandArgument = consoleArgument.getValue();
        prepareCommand();
        executeCommand();
      }
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

  public void getCommands() {
    consoleArguments = new HashMap<>();
    String line = null;
    try {
      line = consoleReader.readCommand().trim();
    } catch (IOException e) {
      System.out.println("Something wrong with command line");
      e.printStackTrace();
    }
    String[] arguments = line.split(" ");

    boolean breakIt = false;
    for (int i = 0; i < arguments.length; i += 2) {
      if (arguments.length % 2 == 1) {
        if (i == arguments.length - 2) {
          breakIt = true;
        }
      }
      String first = arguments[i];
      String second = "";
      if (arguments.length % 2 == 0) {
        second = arguments[i + 1];
      }
      consoleArguments.put(first, second);
      if (breakIt) {
        break;
      }
    }
  }

  public void prepareCommand() {
    commandToExecute = CommandFactory.getCommand(command);
  }

  public void executeCommand() {
    if (commandToExecute != null) {
      filteredMovieList = commandToExecute.execute(filteredMovieList, commandArgument);
    }
  }

  public List<Movie> getMovieList() {
    return movieList;
  }
}