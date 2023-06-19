package academy.mindswap.andrecastrosousa.command.action;

import academy.mindswap.andrecastrosousa.state.needs.NeedStatus;

import java.util.List;

public class SleepAction extends Action {
    public SleepAction(List<NeedStatus> needs) {
        super(ActionType.SLEEP, needs);
    }
}
