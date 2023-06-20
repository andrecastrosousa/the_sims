package academy.mindswap.andrecastrosousa.command.action;

import academy.mindswap.andrecastrosousa.domain.Sim;
import academy.mindswap.andrecastrosousa.domain.Division;
import academy.mindswap.andrecastrosousa.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.exceptions.HouseTooDirtyException;

public abstract class Action implements ActionCommand {

    protected final ActionType type;

    protected Sim sim;

    public Action(ActionType type) {
        this.type = type;
    };

    @Override
    public void perform(Division division) throws CharacterFullBladderException, HouseTooDirtyException, CharacterNoEnergyException {
        sim.goTo(division);
    }

    @Override
    public ActionType getType() {
        return type;
    }

    @Override
    public void setCharacter(Sim sim) {
        this.sim = sim;
    }
}
