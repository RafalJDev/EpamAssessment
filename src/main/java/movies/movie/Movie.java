package movies.movie;

/**
 * Created by Jaszczynski.Rafal on 26.03.2018.
 */
public class Movie {
  private String movieTitle;
  private Integer year;
  private Double averageRating;
  private Integer countOfRatings;

  public Movie(String movieTitle, Integer year, Double averageRating, Integer countOfRatings) {
    this.movieTitle = movieTitle;
    this.year = year;
    this.averageRating = averageRating;
    this.countOfRatings = countOfRatings;
  }

  public String getMovieTitle() {
    return movieTitle;
  }

  public void setMovieTitle(String movieTitle) {
    this.movieTitle = movieTitle;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public Double getAverageRating() {
    return averageRating;
  }

  public void setAverageRating(Double averageRating) {
    this.averageRating = averageRating;
  }

  public Integer getCountOfRatings() {
    return countOfRatings;
  }

  public void setCountOfRatings(Integer countOfRatings) {
    this.countOfRatings = countOfRatings;
  }
}
