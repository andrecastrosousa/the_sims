package academy.mindswap.andrecastrosousa.client.menu.commands.navigate;

import academy.mindswap.andrecastrosousa.client.menu.commands.Command;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.exit(0);
    }
}
