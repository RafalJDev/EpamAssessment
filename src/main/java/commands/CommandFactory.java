package commands;

/**
 * Created by Jaszczynski.Rafal on 26.03.2018.
 */
public class CommandFactory {

  public static Command getCommand(String command) {

    Command commandToExecute = null;
    if (command.equals("ShowMovieCount")) {
      commandToExecute = new ShowMovieCountCommand();
    } else if (command.equals("FilterByRatingBetterThan")) {
      commandToExecute = new FilterByRatingBetterThanCommand();
    } else if (command.equals("Reset")) {
      commandToExecute = new ResetCommand();
    } else if (command.equals("FilterByRatingWorseThan")) {
      commandToExecute = new FilterByRatingWorseThanCommand();
    } else if (command.equals("FilterByYearOfProduction")) {
      commandToExecute = new FilterByYearOfProductionCommand();
    } else if (command.equals("ShowTitles")) {
      commandToExecute = new ShowTitlesCommand();
    } else {
      if (!command.equals("exit"))
        System.out.println("There is no such command: " + command);
    }

    return commandToExecute;
  }
}
