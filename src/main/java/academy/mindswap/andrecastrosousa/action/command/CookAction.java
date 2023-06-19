package academy.mindswap.andrecastrosousa.action.command;

import academy.mindswap.andrecastrosousa.character.needs.NeedStatus;

import java.util.List;

public class CookAction extends Action {
    public CookAction(List<NeedStatus> needs) {
        super(needs, ActionType.COOK);
    }
}