package movies;

import movies.movie.Movie;
import sun.nio.cs.ext.ISCII91;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaszczynski.Rafal on 26.03.2018.
 */
public class MoviesList {

  private static List<Movie> listOfMovies = new ArrayList<Movie>();

  private static MoviesList ourInstance = new MoviesList();

  public static MoviesList getInstance() {
    return ourInstance;
  }

  private MoviesList() {
  }

  public static List<Movie> getListOfMovies() {
    return listOfMovies;
  }

  public static void setListOfMovies(List<Movie> listOfMovies) {
    MoviesList.listOfMovies = listOfMovies;
  }

  public void addMovieToTheList(Movie movie) {
    listOfMovies.add(movie);
  }
}
