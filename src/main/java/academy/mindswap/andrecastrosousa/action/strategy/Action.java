package academy.mindswap.andrecastrosousa.action.strategy;

import academy.mindswap.andrecastrosousa.character.needs.NeedStatus;

import java.util.List;

public class Action implements ActionCommand {

    private final List<NeedStatus> needs;

    public Action(List<NeedStatus> needs) {
        this.needs = needs;
    };

    @Override
    public void perform() {
        
    }
}
