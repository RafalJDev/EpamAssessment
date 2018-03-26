import file.Reader;
import movies.MovieFinder;

import java.util.List;

/**
 * Created by Jaszczynski.Rafal on 27.02.2018.
 */
public class Main {



  public static void main(String[] args) {

    Reader reader = new Reader();
    List<String> linesList = reader.readTxtFile(args[0]);

    MovieFinder mpc = new MovieFinder();

    for (String line : linesList) {
      mpc.searchForMovieWithRegex(line);
    }

  }
}
