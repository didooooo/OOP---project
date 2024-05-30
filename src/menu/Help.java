package menu;

import help.HelpCommand;
import user.User;

public class Help implements MenuCommand{
    private HelpCommand helpCommand;

    public Help(HelpCommand helpCommand) {
        this.helpCommand = helpCommand;
    }

    @Override
    public void execute(String[] data, User... user) {
        helpCommand.help();
    }
}
