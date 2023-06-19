package academy.mindswap.andrecastrosousa.menu.command;

import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.exceptions.HouseTooDirtyException;
import academy.mindswap.andrecastrosousa.house.Division;
import academy.mindswap.andrecastrosousa.house.House;

public class DoActionCommand implements Command {
    private final Character character;

    private final Division division;

    public DoActionCommand(Character character, Division division) {
        this.character = character;
        this.division = division;
    }

    @Override
    public void execute() throws HouseTooDirtyException {
        House house = character.getHouse();

        house.increaseDirtyLevel();

        division.performAction();

        System.out.println(character.getNeeds());
        System.out.println(house.toString());
    }
}
