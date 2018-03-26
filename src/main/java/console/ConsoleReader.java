package console;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Scanner;

/**
 * Created by Jaszczynski.Rafal on 26.03.2018.
 */
public class ConsoleReader {

  Scanner in;

  public ConsoleReader() {
    in = new Scanner(System.in);
  }

  public String readCommand() {
    return in.next();
  }
}
