package academy.mindswap.andrecastrosousa.command.menu.navigate;

import academy.mindswap.andrecastrosousa.command.menu.Command;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.exit(0);
    }
}
