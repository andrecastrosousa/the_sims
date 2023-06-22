package academy.mindswap.andrecastrosousa.command.action;

import academy.mindswap.andrecastrosousa.domain.enums.ActionType;

public class WorkAction extends Action {

    public WorkAction() {
        super(ActionType.WORK);
    }

    @Override
    public String toString() {
        return "Work";
    }
}
