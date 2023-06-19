package academy.mindswap.andrecastrosousa.action.command;

import academy.mindswap.andrecastrosousa.character.needs.NeedStatus;

import java.util.List;

public class SleepAction extends Action {
    public SleepAction(List<NeedStatus> needs) {
        super(ActionType.SLEEP, needs);
    }
}
