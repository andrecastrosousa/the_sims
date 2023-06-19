package academy.mindswap.andrecastrosousa.command.action;

import academy.mindswap.andrecastrosousa.template.NeedStatus;

import java.util.List;

public abstract class Action implements ActionCommand {

    protected final ActionType type;

    protected final List<NeedStatus> needs;

    public Action(ActionType type, List<NeedStatus> needs) {
        this.type = type;
        this.needs = needs;
    };

    @Override
    public List<NeedStatus> perform() {
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
