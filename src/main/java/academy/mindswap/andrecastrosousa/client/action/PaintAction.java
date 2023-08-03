package academy.mindswap.andrecastrosousa.client.action;

import academy.mindswap.andrecastrosousa.client.menu.enums.ActionType;

public class PaintAction extends Action {

    public PaintAction() {
        super(ActionType.PAINT);
    }

    @Override
    public String toString() {
        return "Paint";
    }
}
