package academy.mindswap.andrecastrosousa.command.action;

import academy.mindswap.andrecastrosousa.template.NeedStatus;

import java.util.List;

public interface ActionCommand {
    List<NeedStatus> perform();

    ActionType getType();
}
