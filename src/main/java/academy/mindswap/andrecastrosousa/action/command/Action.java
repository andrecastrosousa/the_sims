package academy.mindswap.andrecastrosousa.action.command;

import academy.mindswap.andrecastrosousa.character.needs.NeedStatus;

import java.util.List;

/**
 * Design Pattern: Observer
 *
 * Publisher
 */
public abstract class Action implements ActionCommand {

    protected final ActionType type;

    public Action(ActionType type) {
        this.type = type;
    };
    
    @Override
    public List<NeedStatus> perform(List<NeedStatus> needs) {
        for(NeedStatus needStatus: needs) {
            int staminaCost = type.getStaminaCost(needStatus);
            needStatus.update(staminaCost);
        }

        return needs;
    }

    @Override
    public ActionType getType() {
        return type;
    }
}
