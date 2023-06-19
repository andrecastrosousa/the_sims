package academy.mindswap.andrecastrosousa.command.action;

import academy.mindswap.andrecastrosousa.state.needs.NeedStatus;

import java.util.List;

public class EatAction extends Action {
    public EatAction(List<NeedStatus> needs) {
        super(ActionType.EAT, needs);
    }
}
