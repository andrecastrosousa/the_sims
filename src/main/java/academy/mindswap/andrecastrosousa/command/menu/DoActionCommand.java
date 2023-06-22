package academy.mindswap.andrecastrosousa.command.menu;

import academy.mindswap.andrecastrosousa.command.action.ActionCommand;
import academy.mindswap.andrecastrosousa.command.action.ActionInvoker;
import academy.mindswap.andrecastrosousa.composite.Division;
import academy.mindswap.andrecastrosousa.composite.Furniture;
import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.Sim;
import academy.mindswap.andrecastrosousa.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.exceptions.HouseTooDirtyException;

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
