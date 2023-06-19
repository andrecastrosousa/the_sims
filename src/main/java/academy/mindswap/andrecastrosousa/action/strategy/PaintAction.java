package academy.mindswap.andrecastrosousa.action.strategy;

import academy.mindswap.andrecastrosousa.action.ActionType;

public class PaintAction implements ActionCommand {

    private final ActionType type = ActionType.PAINT;

    @Override
    public void perform() {

    }
}
