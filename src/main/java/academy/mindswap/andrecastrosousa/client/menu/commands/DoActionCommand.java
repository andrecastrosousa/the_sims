package academy.mindswap.andrecastrosousa.client.menu.commands;

import academy.mindswap.andrecastrosousa.client.action.ActionCommand;
import academy.mindswap.andrecastrosousa.client.action.ActionInvoker;
import academy.mindswap.andrecastrosousa.server.models.Furniture;
import academy.mindswap.andrecastrosousa.Game;
import academy.mindswap.andrecastrosousa.client.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.client.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.client.exceptions.HouseTooDirtyException;

public class DoActionCommand implements Command {
    private final Furniture furniture;

    private final ActionInvoker commandInvoker;

    public DoActionCommand(Furniture furniture) {
        this.furniture = furniture;
        commandInvoker = new ActionInvoker();
    }

    @Override
    public void execute() throws CharacterNoEnergyException, CharacterFullBladderException, HouseTooDirtyException {
        ActionCommand command = furniture.getAction();

        commandInvoker.setActionCommand(command);
        commandInvoker.invoke(furniture);

        System.out.println(Game.getSim().getNeeds());
    }
}
