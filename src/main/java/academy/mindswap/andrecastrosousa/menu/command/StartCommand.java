package academy.mindswap.andrecastrosousa.menu.command;

import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoHouseException;
import academy.mindswap.andrecastrosousa.menu.command.Command;

public class StartCommand implements Command {
    private final Character character;

    public StartCommand(Character character) {
        this.character = character;
    }

    @Override
    public void execute() throws CharacterNoHouseException {
        if(character.getHouse() == null) {
            throw new CharacterNoHouseException();
        }
    }
}
