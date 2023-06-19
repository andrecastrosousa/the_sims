package academy.mindswap.andrecastrosousa.action.command;

import academy.mindswap.andrecastrosousa.character.needs.NeedStatus;

import java.util.List;

/**
 * Design Pattern: Observer
 *
 * Publisher
 */
public abstract class Action implements ActionCommand {

    protected final List<NeedStatus> needs;
    protected final ActionType type;

    public Action(List<NeedStatus> needs, ActionType type) {
        this.needs = needs;
        this.type = type;
    };

    public void attach(NeedStatus needStatus) {
        needs.add(needStatus);
    }

    public void detach(NeedStatus needStatus) {
        needs.remove(needStatus);
    }

    private void notifyNeeds() {
        for(NeedStatus needStatus: needs) {
            int staminaCost = type.getStaminaCost(needStatus);
            needStatus.update(staminaCost);
        }
    }

    @Override
    public void perform() {
        notifyNeeds();
    }

    @Override
    public ActionType getType() {
        return type;
    }
}
