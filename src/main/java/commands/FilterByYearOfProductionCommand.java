package commands;

import movies.movie.Movie;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Jaszczynski.Rafal on 26.03.2018.
 */
public class FilterByYearOfProductionCommand extends Command {
  @Override
  public List<Movie> execute(List<Movie> movieList, String argument) {
    return movieList
       .stream()
       .filter(movie -> movie.getYear() == Integer.parseInt(argument))
       .collect(Collectors.toList());
  }
}
