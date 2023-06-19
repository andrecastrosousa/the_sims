package academy.mindswap.andrecastrosousa.action.command;

import academy.mindswap.andrecastrosousa.character.needs.NeedStatus;

import java.util.List;

public class PaintAction extends Action {
    public PaintAction(List<NeedStatus> needs) {
        super(ActionType.PAINT, needs);
    }
}
