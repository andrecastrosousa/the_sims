package academy.mindswap.andrecastrosousa.command.action;

import academy.mindswap.andrecastrosousa.state.needs.NeedStatus;

import java.util.List;

public class ActionInvoker {

    private ActionCommand actionCommand;

    public void setActionCommand(ActionCommand actionCommand) {
        this.actionCommand = actionCommand;
    }

    public List<NeedStatus> invoke() {
        return actionCommand.perform();
    }
}
