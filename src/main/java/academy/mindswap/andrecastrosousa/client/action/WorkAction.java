package academy.mindswap.andrecastrosousa.client.action;

import academy.mindswap.andrecastrosousa.client.menu.enums.ActionType;

public class WorkAction extends Action {

    public WorkAction() {
        super(ActionType.WORK);
    }

    @Override
    public String toString() {
        return "Work";
    }
}
