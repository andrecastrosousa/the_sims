package academy.mindswap.andrecastrosousa.action.strategy;

import academy.mindswap.andrecastrosousa.character.needs.NeedStatus;

import java.util.List;

public class WorkAction extends Action {
    public WorkAction(List<NeedStatus> needs) {
        super(needs, ActionType.WORK);
    }
}
