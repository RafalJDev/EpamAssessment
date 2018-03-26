package commands;

import movies.movie.Movie;

import java.util.List;

/**
 * Created by Jaszczynski.Rafal on 26.03.2018.
 */
public abstract class Command {

  public static String commandName;

  public abstract void execute(List<Movie> movieList);
}
