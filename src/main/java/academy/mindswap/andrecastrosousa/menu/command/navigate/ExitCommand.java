package academy.mindswap.andrecastrosousa.menu.command.navigate;

import academy.mindswap.andrecastrosousa.exceptions.ExitApplication;
import academy.mindswap.andrecastrosousa.menu.command.Command;

public class ExitCommand implements Command {
    @Override
    public void execute() throws ExitApplication {
        throw new ExitApplication();
    }
}
