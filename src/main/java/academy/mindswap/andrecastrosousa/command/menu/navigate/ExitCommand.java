package academy.mindswap.andrecastrosousa.command.menu.navigate;

import academy.mindswap.andrecastrosousa.command.menu.Command;
import academy.mindswap.andrecastrosousa.exceptions.ExitApplication;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.exit(0);
    }
}
