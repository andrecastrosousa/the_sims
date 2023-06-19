package academy.mindswap.andrecastrosousa.command.menu;

import academy.mindswap.andrecastrosousa.domain.Character;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoHouseException;
import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;

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
        Game.setMenuType(MenuType.SIM_MENU);
    }
}
