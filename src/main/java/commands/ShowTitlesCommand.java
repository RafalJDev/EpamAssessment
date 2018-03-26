package commands;

import movies.movie.Movie;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Jaszczynski.Rafal on 26.03.2018.
 */
public class ShowTitlesCommand extends Command {
  @Override
  public List<Movie> execute(List<Movie> movieList, String argument) {
    movieList
       .stream()
       .forEach(movie->System.out.println(movie.getMovieTitle()));
    return movieList;
  }
}
