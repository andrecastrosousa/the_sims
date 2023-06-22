package academy.mindswap.andrecastrosousa.menu.commands.navigate;

import academy.mindswap.andrecastrosousa.menu.commands.Command;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.exit(0);
    }
}
