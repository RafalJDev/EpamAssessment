package movies;

import sun.nio.cs.ext.ISCII91;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaszczynski.Rafal on 26.03.2018.
 */
public class MoviesList {

  private static List<String> listOfMovies = new ArrayList<String>();

  private static MoviesList ourInstance = new MoviesList();

  public static MoviesList getInstance() {
    return ourInstance;
  }

  private MoviesList() {
  }

  public static List<String> getListOfMovies() {
    return listOfMovies;
  }

  public static void setListOfMovies(List<String> listOfMovies) {
    MoviesList.listOfMovies = listOfMovies;
  }

  public void addMovieToTheList(String movie) {
    listOfMovies.add(movie);
  }
}
