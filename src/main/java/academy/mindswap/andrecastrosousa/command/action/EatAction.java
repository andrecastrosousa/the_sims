package academy.mindswap.andrecastrosousa.command.action;

import academy.mindswap.andrecastrosousa.template.NeedStatus;

import java.util.List;

public class EatAction extends Action {
    public EatAction(List<NeedStatus> needs) {
        super(ActionType.EAT, needs);
    }
}
