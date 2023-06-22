package academy.mindswap.andrecastrosousa.action;

import academy.mindswap.andrecastrosousa.menu.enums.ActionType;

public class CookAction extends Action {

    public CookAction() {
        super(ActionType.COOK);
    }

    @Override
    public String toString() {
        return "Cook";
    }
}