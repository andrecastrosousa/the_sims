package academy.mindswap.andrecastrosousa.menu.command;

import academy.mindswap.andrecastrosousa.action.command.Action;
import academy.mindswap.andrecastrosousa.action.command.ActionCommand;
import academy.mindswap.andrecastrosousa.action.command.ActionInvoker;
import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.character.needs.NeedStatus;
import academy.mindswap.andrecastrosousa.exceptions.HouseTooDirtyException;
import academy.mindswap.andrecastrosousa.house.Division;
import academy.mindswap.andrecastrosousa.house.House;

import java.util.List;

public class DoActionCommand implements Command {
    private final Character character;

    private final ActionCommand actionCommand;

    private final ActionInvoker commandInvoker;

    public DoActionCommand(Character character, ActionCommand actionCommand) {
        this.character = character;
        this.actionCommand = actionCommand;
        commandInvoker = new ActionInvoker();
    }

    @Override
    public void execute() throws HouseTooDirtyException {
        House house = character.getHouse();

        house.increaseDirtyLevel();

        commandInvoker.setActionCommand(actionCommand);
        List<NeedStatus> needsUpdated = commandInvoker.invoke();

        character.setNeeds(needsUpdated);

        System.out.println(character.getNeeds());
        System.out.println(house.toString());
    }
}
