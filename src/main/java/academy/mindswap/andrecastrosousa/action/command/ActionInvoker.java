package academy.mindswap.andrecastrosousa.action.command;

import academy.mindswap.andrecastrosousa.character.needs.NeedStatus;

import java.util.List;

public class ActionInvoker {

    private ActionCommand actionCommand;

    public void setActionCommand(ActionCommand actionCommand) {
        this.actionCommand = actionCommand;
    }

    public void invoke(List<NeedStatus> needs) {
        actionCommand.perform(needs);
    }
}
