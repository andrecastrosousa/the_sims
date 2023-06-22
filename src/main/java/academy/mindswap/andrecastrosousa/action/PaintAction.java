package academy.mindswap.andrecastrosousa.action;

import academy.mindswap.andrecastrosousa.menu.enums.ActionType;

public class PaintAction extends Action {

    public PaintAction() {
        super(ActionType.PAINT);
    }

    @Override
    public String toString() {
        return "Paint";
    }
}
