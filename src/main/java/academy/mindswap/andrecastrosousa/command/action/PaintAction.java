package academy.mindswap.andrecastrosousa.command.action;

import academy.mindswap.andrecastrosousa.domain.enums.ActionType;

public class PaintAction extends Action {

    public PaintAction() {
        super(ActionType.PAINT);
    }

    @Override
    public String toString() {
        return "Paint";
    }
}
