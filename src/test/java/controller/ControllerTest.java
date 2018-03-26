package controller;

import movies.movie.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Jaszczynski.Rafal on 26.03.2018.
 */
public class ControllerTest {

  Controller controller;

  @Before
  public void setUp() throws Exception {
    controller = new Controller("MoviesList.txt");
  }

  @Test
  public void whenGettingAllMoviesThenCheckIfTitlesExist() throws Exception {
    controller.getAllMovies();

    List<Movie> movieList = controller.getMovieList();
    Movie firstMovie = movieList.get(0);
    Movie lastMovie= movieList.get(movieList.size()-1);

    assertEquals("Leave It to Beaver",firstMovie.getMovieTitle());
    assertEquals("Mat' i syn",lastMovie.getMovieTitle());
  }

}