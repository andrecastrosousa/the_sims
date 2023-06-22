package academy.mindswap.andrecastrosousa.command.action;

import academy.mindswap.andrecastrosousa.domain.enums.ActionType;

public class SleepAction extends Action {

    public SleepAction() {
        super(ActionType.SLEEP);
    }

    @Override
    public String toString() {
        return "Sleep";
    }
}
