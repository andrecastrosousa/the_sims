package academy.mindswap.andrecastrosousa.command.action;

import academy.mindswap.andrecastrosousa.composite.Furniture;
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
