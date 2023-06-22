package academy.mindswap.andrecastrosousa.action;

import academy.mindswap.andrecastrosousa.menu.enums.ActionType;

public class SleepAction extends Action {

    public SleepAction() {
        super(ActionType.SLEEP);
    }

    @Override
    public String toString() {
        return "Sleep";
    }
}
