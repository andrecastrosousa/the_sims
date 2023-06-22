package academy.mindswap.andrecastrosousa.action;

import academy.mindswap.andrecastrosousa.menu.enums.ActionType;

public class WorkAction extends Action {

    public WorkAction() {
        super(ActionType.WORK);
    }

    @Override
    public String toString() {
        return "Work";
    }
}
