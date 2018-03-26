package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Jaszczynski.Rafal on 26.03.2018.
 */
public class Reader {

  private String filePathToReadFrom;
  private final String FILENAME = "MoviesList.txt";

  private BufferedReader br = null;
  private FileReader fr = null;

  public void readTxtFile() {

    findPathForParsedFileByName(System.getProperty("user.dir"));

    try {
      //br = new BufferedReader(new FileReader(FILENAME));
      fr = new FileReader(filePathToReadFrom);
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

  public void findPathForParsedFileByName(String directoryName) {
    File directory = new File(directoryName);
    File[] fList = directory.listFiles();
    for (File file : fList) {
      if (file.isFile()) {
        if (file.getAbsolutePath().contains(FILENAME)) {
          filePathToReadFrom = file.getAbsolutePath().trim();
        }
      } else if (file.isDirectory()) {
        findPathForParsedFileByName(file.getAbsolutePath());
      }
    }
  }
}
