package academy.mindswap.andrecastrosousa.client.action;

import academy.mindswap.andrecastrosousa.client.menu.enums.ActionType;

public class PeeAction extends Action {

    public PeeAction() {
        super(ActionType.PEE);
    }

    @Override
    public String toString() {
        return "Pee";
    }
}
