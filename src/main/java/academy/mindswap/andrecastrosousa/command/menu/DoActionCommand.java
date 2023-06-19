package academy.mindswap.andrecastrosousa.command.menu;

import academy.mindswap.andrecastrosousa.command.action.ActionCommand;
import academy.mindswap.andrecastrosousa.command.action.ActionInvoker;
import academy.mindswap.andrecastrosousa.domain.Character;
import academy.mindswap.andrecastrosousa.domain.Division;
import academy.mindswap.andrecastrosousa.exceptions.HouseTooDirtyException;
import academy.mindswap.andrecastrosousa.domain.House;

public class DoActionCommand implements Command {
    private final Character character;

    private final Division division;

    private final ActionInvoker commandInvoker;

    public DoActionCommand(Character character, Division division) {
        this.character = character;
        this.division = division;
        commandInvoker = new ActionInvoker();
    }

    @Override
    public void execute() throws HouseTooDirtyException {
        House house = character.getHouse();

        house.increaseDirtyLevel();

        ActionCommand command = division.getAction();
        command.setCharacter(character);

        commandInvoker.setActionCommand(command);
        commandInvoker.invoke(division);

        System.out.println(character.getNeeds());
    }
}
