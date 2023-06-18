package academy.mindswap.andrecastrosousa.menu.command;

import academy.mindswap.andrecastrosousa.exceptions.ExitApplication;

public class ExitCommand implements Command {
    @Override
    public void execute() throws ExitApplication {
        throw new ExitApplication();
    }
}
