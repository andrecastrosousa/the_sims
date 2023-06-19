package academy.mindswap.andrecastrosousa.action.strategy;

import academy.mindswap.andrecastrosousa.character.needs.NeedStatus;

import java.util.List;

public class PaintAction extends Action {
    public PaintAction(List<NeedStatus> needs) {
        super(needs, ActionType.PAINT);
    }
}
