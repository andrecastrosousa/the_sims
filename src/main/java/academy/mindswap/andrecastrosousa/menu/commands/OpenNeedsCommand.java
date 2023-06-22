package academy.mindswap.andrecastrosousa.menu.commands;

import academy.mindswap.andrecastrosousa.character.needs.status.NeedStatus;
import academy.mindswap.andrecastrosousa.utils.Messages;

import java.util.List;

public class OpenNeedsCommand implements Command {

    private final List<NeedStatus> needs;

    public OpenNeedsCommand(List<NeedStatus> needs) {
        this.needs = needs;
    }

    @Override
    public void execute() {
        System.out.println("\n" + Messages.SEPARATOR);
        for (NeedStatus need: needs) {
            System.out.println(need);
        }
        System.out.println(Messages.SEPARATOR + "\n");
    }
}