package academy.mindswap.andrecastrosousa.action;

import academy.mindswap.andrecastrosousa.menu.enums.ActionType;

public class PeeAction extends Action {

    public PeeAction() {
        super(ActionType.PEE);
    }

    @Override
    public String toString() {
        return "Pee";
    }
}
