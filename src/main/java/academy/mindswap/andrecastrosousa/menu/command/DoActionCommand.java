package academy.mindswap.andrecastrosousa.menu.command;

import academy.mindswap.andrecastrosousa.action.Action;
import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoActionException;
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

        Action action = character.getActions().stream()
                .filter(a -> a.getType() == division.getType())
                .findFirst()
                .orElseThrow();

        action.increaseStamina(division.getStaminaCost());
        System.out.println(character.getActions());
        System.out.println(house.toString());
    }
}
