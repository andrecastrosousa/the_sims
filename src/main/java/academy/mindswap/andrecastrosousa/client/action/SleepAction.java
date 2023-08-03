package academy.mindswap.andrecastrosousa.client.action;

import academy.mindswap.andrecastrosousa.client.menu.enums.ActionType;

public class SleepAction extends Action {

    public SleepAction() {
        super(ActionType.SLEEP);
    }

    @Override
    public String toString() {
        return "Sleep";
    }
}
