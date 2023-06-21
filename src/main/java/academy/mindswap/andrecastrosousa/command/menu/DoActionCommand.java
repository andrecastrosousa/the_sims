package academy.mindswap.andrecastrosousa.command.menu;

import academy.mindswap.andrecastrosousa.command.action.ActionCommand;
import academy.mindswap.andrecastrosousa.command.action.ActionInvoker;
import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.Sim;
import academy.mindswap.andrecastrosousa.domain.Division;
import academy.mindswap.andrecastrosousa.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.exceptions.HouseTooDirtyException;

public class DoActionCommand implements Command {
    private final Division division;

    private final ActionInvoker commandInvoker;

    public DoActionCommand(Sim sim, Division division) {
        this.division = division;
        commandInvoker = new ActionInvoker();
    }

    @Override
    public void execute() throws CharacterNoEnergyException, CharacterFullBladderException, HouseTooDirtyException {
        ActionCommand command = division.getAction();


        commandInvoker.setActionCommand(command);
        commandInvoker.invoke(division);

        System.out.println(Game.getSim().getNeeds());
    }
}
