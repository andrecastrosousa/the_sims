package academy.mindswap.andrecastrosousa.action.strategy;

public class ActionInvoker {

    private ActionCommand actionCommand;

    public void setActionCommand(ActionCommand actionCommand) {
        this.actionCommand = actionCommand;
    }

    public void invoke() {
        actionCommand.perform();
    }
}
