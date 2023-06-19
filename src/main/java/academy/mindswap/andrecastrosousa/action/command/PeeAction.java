package academy.mindswap.andrecastrosousa.action.command;

import academy.mindswap.andrecastrosousa.character.needs.NeedStatus;

import java.util.List;

public class PeeAction extends Action {
    public PeeAction(List<NeedStatus> needs) {
        super(ActionType.PEE, needs);
    }
}
