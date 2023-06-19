package academy.mindswap.andrecastrosousa.command.action;

import academy.mindswap.andrecastrosousa.template.NeedStatus;

import java.util.List;

public class CookAction extends Action {
    public CookAction(List<NeedStatus> needs) {
        super(ActionType.COOK, needs);
    }
}