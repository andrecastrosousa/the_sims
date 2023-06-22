package academy.mindswap.andrecastrosousa.action;

import academy.mindswap.andrecastrosousa.menu.enums.ActionType;

public class EatAction extends Action {

    public EatAction() {
        super(ActionType.EAT);
    }

    @Override
    public String toString() {
        return "Eat";
    }
}
