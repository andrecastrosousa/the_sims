package academy.mindswap.andrecastrosousa.command.action;

import academy.mindswap.andrecastrosousa.domain.enums.ActionType;

public class CookAction extends Action {

    public CookAction() {
        super(ActionType.COOK);
    }

    @Override
    public String toString() {
        return "Cook";
    }
}