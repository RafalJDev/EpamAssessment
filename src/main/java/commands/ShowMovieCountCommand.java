package commands;

import movies.movie.Movie;

import java.util.List;

/**
 * Created by Jaszczynski.Rafal on 26.03.2018.
 */
public class ShowMovieCountCommand extends Command {

  public List<Movie> execute(List<Movie> movieList, String argument) {
    System.out.println("There is: " + movieList.size() + " movies");
    return movieList;
  }
}
