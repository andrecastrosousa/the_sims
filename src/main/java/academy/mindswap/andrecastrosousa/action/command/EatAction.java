package academy.mindswap.andrecastrosousa.action.command;

import academy.mindswap.andrecastrosousa.character.needs.NeedStatus;

import java.util.List;

public class EatAction extends Action {
    public EatAction(List<NeedStatus> needs) {
        super(ActionType.EAT, needs);
    }
}
