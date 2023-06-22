package academy.mindswap.andrecastrosousa.command.action;

import academy.mindswap.andrecastrosousa.domain.enums.ActionType;

public class PeeAction extends Action {

    public PeeAction() {
        super(ActionType.PEE);
    }

    @Override
    public String toString() {
        return "Pee";
    }
}
