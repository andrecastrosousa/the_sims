package academy.mindswap.andrecastrosousa.command.action;

import academy.mindswap.andrecastrosousa.template.NeedStatus;

import java.util.List;

public class PaintAction extends Action {
    public PaintAction(List<NeedStatus> needs) {
        super(ActionType.PAINT, needs);
    }
}
