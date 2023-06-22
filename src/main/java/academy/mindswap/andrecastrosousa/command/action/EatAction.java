package academy.mindswap.andrecastrosousa.command.action;

import academy.mindswap.andrecastrosousa.domain.enums.ActionType;

public class EatAction extends Action {

    public EatAction() {
        super(ActionType.EAT);
    }

    @Override
    public String toString() {
        return "Eat";
    }
}
