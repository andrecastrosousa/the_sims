package academy.mindswap.andrecastrosousa.action.strategy;

import academy.mindswap.andrecastrosousa.character.needs.NeedStatus;

import java.util.List;

public class PeeAction extends Action {
    public PeeAction(List<NeedStatus> needs) {
        super(needs, ActionType.PEE);
    }
}
