package academy.mindswap.andrecastrosousa.client.action;

import academy.mindswap.andrecastrosousa.server.models.Furniture;
import academy.mindswap.andrecastrosousa.client.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.client.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.client.exceptions.HouseTooDirtyException;

public class ActionInvoker {

    private ActionCommand actionCommand;

    public void setActionCommand(ActionCommand actionCommand) {
        this.actionCommand = actionCommand;
    }

    public void invoke(Furniture furniture) throws CharacterFullBladderException, HouseTooDirtyException, CharacterNoEnergyException {
        actionCommand.interact(furniture);
    }
}
