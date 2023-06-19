package academy.mindswap.andrecastrosousa.command.action;

import academy.mindswap.andrecastrosousa.state.needs.NeedStatus;

import java.util.List;

public class WorkAction extends Action {
    public WorkAction(List<NeedStatus> needs) {
        super(ActionType.WORK, needs);
    }
}
