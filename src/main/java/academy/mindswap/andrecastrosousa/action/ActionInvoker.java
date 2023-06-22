package academy.mindswap.andrecastrosousa.action;

import academy.mindswap.andrecastrosousa.house.Furniture;
import academy.mindswap.andrecastrosousa.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.exceptions.HouseTooDirtyException;

public class ActionInvoker {

    private ActionCommand actionCommand;

    public void setActionCommand(ActionCommand actionCommand) {
        this.actionCommand = actionCommand;
    }

    public void invoke(Furniture furniture) throws CharacterFullBladderException, HouseTooDirtyException, CharacterNoEnergyException {
        actionCommand.interact(furniture);
    }
}
