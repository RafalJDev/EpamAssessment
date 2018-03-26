package console;

import com.sun.org.apache.regexp.internal.RE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Jaszczynski.Rafal on 26.03.2018.
 */
public class ConsoleReader {

  public ConsoleReader() {
  }

  public String readCommand() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter String");
    System.out.println();

    String s = br.readLine();
    System.out.println();

    return s;
  }
}
