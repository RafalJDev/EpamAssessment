package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaszczynski.Rafal on 26.03.2018.
 */
public class Reader {

  private String filePathToReadFrom;
  private String fileName;

  private BufferedReader br = null;
  private FileReader fr = null;

  private List<String> linesList = new ArrayList<String>();

  public Reader(String fileName) {
    if (fileName == null) {
      throw new NullPointerException();
    }
    this.fileName = fileName;
//    findPathForParsedFileByName(System.getProperty("user.dir"));
    findPathForParsedFileByName("D:\\Programowanko\\jaszc\\Intelij_projects\\EpamAssessment");
  }

  public List<String> readTxtFile() {
    try {
      fr = new FileReader(filePathToReadFrom);
      br = new BufferedReader(fr);

      String sCurrentLine;
      while ((sCurrentLine = br.readLine()) != null) {
        linesList.add(sCurrentLine);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      closeReader();
    }
    return linesList;
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
        if (file.getAbsolutePath().contains(fileName)) {
          filePathToReadFrom = file.getAbsolutePath().trim();
        }
      } else if (file.isDirectory()) {
        findPathForParsedFileByName(file.getAbsolutePath());
      }
    }
  }
}
