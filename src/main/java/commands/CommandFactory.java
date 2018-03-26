package commands;

/**
 * Created by Jaszczynski.Rafal on 26.03.2018.
 */
public class CommandFactory {

  public static Command getCommand(String command) {

    Command commandToExecute = null;
    if (command.equals("ShowMovieCount")) {
      commandToExecute = new ShowMovieCountCommand();
    } else if (command.equals("sbfdb")) {
    } else {
      System.out.println("You did enter wrong command: " + command);

    }

    return commandToExecute;
  }
}
