package academy.mindswap.andrecastrosousa.command.action;

import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.Sim;
import academy.mindswap.andrecastrosousa.domain.Division;
import academy.mindswap.andrecastrosousa.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.exceptions.HouseTooDirtyException;

public abstract class Action implements ActionCommand {

    protected final ActionType type;

    public Action(ActionType type) {
        this.type = type;
    };

    @Override
    public void perform(Division division) throws CharacterFullBladderException, HouseTooDirtyException, CharacterNoEnergyException {
        Game.getSim().goTo(division);
    }

    @Override
    public ActionType getType() {
        return type;
    }
}
