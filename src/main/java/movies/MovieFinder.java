package movies;

import movies.movie.Movie;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jaszczynski.Rafal on 26.03.2018.
 */
public class MovieFinder {

  private Movie movie;

  private final String movieTitlePattern = "(.+)";
  private final String yearPattern = "(\\d{4})";
  private final String averageRatingPattern = "(\\d+\\.\\d+)";
  private final String countOfRatingsPattern = "(\\d+)";

  private final Pattern pattern = Pattern.compile(
     "\\(" +
        movieTitlePattern + "," +
        yearPattern + "," +
        averageRatingPattern + "," +
        countOfRatingsPattern
        + "\\)");

  public Movie searchForMovieWithRegex(String movieLine) {
    //\((.+),(\d{4}),(\d+\.\d+),(\d+)\)
    Matcher matcher = pattern.matcher(movieLine);

    if (matcher.find()) {
      printToTest(matcher);
      createMovie(matcher);
    } else {
      movie = null;
    }
    return movie;
  }

  public void createMovie(Matcher matcher) {
    String movieTitle = matcher.group(1);
    Integer movieYear = Integer.valueOf(matcher.group(2));
    Double averageRating = Double.valueOf(matcher.group(3));
    Integer countOfRatings = Integer.valueOf(matcher.group(4));

    movie = new Movie(movieTitle, movieYear, averageRating, countOfRatings);
  }

  private void printToTest(Matcher matcher) {
    System.out.println(matcher.group(1));
    System.out.println(matcher.group(2));
    System.out.println(matcher.group(3));
    System.out.println(matcher.group(4));
  }
}
