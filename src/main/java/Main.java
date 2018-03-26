import file.Reader;

/**
 * Created by Jaszczynski.Rafal on 27.02.2018.
 */
public class Main {

  public static void main(String[] args) {

    Reader reader = new Reader();
    reader.readTxtFile(args[0]);
  }
}
