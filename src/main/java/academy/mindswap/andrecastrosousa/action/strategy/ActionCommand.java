package academy.mindswap.andrecastrosousa.action.strategy;

public interface ActionCommand {
    void perform();

    ActionType getType();
}
