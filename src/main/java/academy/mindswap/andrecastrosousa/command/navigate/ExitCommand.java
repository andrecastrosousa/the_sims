package academy.mindswap.andrecastrosousa.command.navigate;

import academy.mindswap.andrecastrosousa.command.menu.Command;
import academy.mindswap.andrecastrosousa.exceptions.ExitApplication;

public class ExitCommand implements Command {
    @Override
    public void execute() throws ExitApplication {
        throw new ExitApplication();
    }
}