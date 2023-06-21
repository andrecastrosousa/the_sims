package academy.mindswap.andrecastrosousa.command.menu;

import academy.mindswap.andrecastrosousa.exceptions.CharacterNoHouseException;
import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;

public class StartCommand implements Command {

    @Override
    public void execute() throws CharacterNoHouseException {
        Game.setMenuType(MenuType.SIM_CREATION_MENU);
    }
}
