package academy.mindswap.andrecastrosousa.action.command;

public interface ActionCommand {
    void perform();

    ActionType getType();
}
