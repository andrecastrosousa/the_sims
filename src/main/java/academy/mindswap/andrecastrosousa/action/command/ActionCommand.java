package academy.mindswap.andrecastrosousa.action.command;

import academy.mindswap.andrecastrosousa.character.needs.NeedStatus;

import java.util.List;

public interface ActionCommand {
    List<NeedStatus> perform();

    ActionType getType();
}
