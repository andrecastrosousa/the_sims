package academy.mindswap.andrecastrosousa.action.command;

import academy.mindswap.andrecastrosousa.character.needs.NeedStatus;

import java.util.List;

public class WorkAction extends Action {
    public WorkAction(List<NeedStatus> needs) {
        super(ActionType.WORK, needs);
    }
}
