package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Jaszczynski.Rafal on 26.03.2018.
 */
public class Reader {

  private final String FILENAME = "";

  BufferedReader br = null;
  FileReader fr = null;

  public void readLine() {
    try {
      //br = new BufferedReader(new FileReader(FILENAME));
      fr = new FileReader(FILENAME);
      br = new BufferedReader(fr);

      String sCurrentLine;

      while ((sCurrentLine = br.readLine()) != null) {
        System.out.println(sCurrentLine);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      closeReader();
    }
  }

  public void closeReader() {
    try {
      if (br != null)
        br.close();
      if (fr != null)
        fr.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
