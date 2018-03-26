package movies;

import movies.movie.Movie;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jaszczynski.Rafal on 26.03.2018.
 */
public class MoviePattern {

  static MoviesList moviesList = MoviesList.getInstance();

  private static final String movieTitlePattern = "(.+)";
  private static final String yearPattern = "(\\d{4})";
  private static final     String avergeRatingPattern = "(\\d+\\.\\d+)";
  private static final String countOfRatingsPattern = "(\\d+)";

  public static boolean checkIfMovieHasCorrectPattern(String movieLine) {

    //\((.+),(\d{4}),(\d+\.\d+),(\d+)\)

    Pattern pattern = Pattern.compile(
       "\\(" +
          movieTitlePattern + "," +
          yearPattern + "," +
          avergeRatingPattern + "," +
          countOfRatingsPattern
          + "\\)");
    Matcher matcher = pattern.matcher(movieLine);

    if (matcher.find()) {
      printToTest(matcher);
      addMovie(matcher);
    }
    return matcher.find();
  }

  private static void printToTest(Matcher matcher) {
    System.out.println(matcher.group(1));
    System.out.println(matcher.group(2));
    System.out.println(matcher.group(3));
    System.out.println(matcher.group(4));
  }

  public static void addMovie(Matcher matcher) {
    String movieTitle = matcher.group(1);
    Integer movieYear = Integer.valueOf(matcher.group(2));
    Double averageRating = Double.valueOf(matcher.group(3));
    Integer countOfRatings = Integer.valueOf(matcher.group(4));

    Movie movie = new Movie(movieTitle, movieYear, averageRating, countOfRatings);

    moviesList.addMovieToTheList(movie);
  }
}
