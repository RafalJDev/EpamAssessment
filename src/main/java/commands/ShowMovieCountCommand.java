package commands;

import movies.movie.Movie;

import java.util.List;

/**
 * Created by Jaszczynski.Rafal on 26.03.2018.
 */
public class ShowMovieCountCommand extends Command {

  public void execute(List<Movie> movieList) {
    System.out.println("There is: " + movieList.size() + " movies");
  }
}
