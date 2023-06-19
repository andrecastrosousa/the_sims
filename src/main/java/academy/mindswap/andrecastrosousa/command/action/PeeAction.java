package academy.mindswap.andrecastrosousa.command.action;

import academy.mindswap.andrecastrosousa.template.NeedStatus;

import java.util.List;

public class PeeAction extends Action {
    public PeeAction(List<NeedStatus> needs) {
        super(ActionType.PEE, needs);
    }
}
