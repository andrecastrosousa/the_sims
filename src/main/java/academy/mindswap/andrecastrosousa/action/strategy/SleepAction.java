package academy.mindswap.andrecastrosousa.action.strategy;

import academy.mindswap.andrecastrosousa.action.ActionType;

public class SleepAction implements ActionCommand {

    private final ActionType type = ActionType.SLEEP;


    @Override
    public void perform() {

    }
}
