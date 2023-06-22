package academy.mindswap.andrecastrosousa.menu.commands;

import academy.mindswap.andrecastrosousa.exceptions.CharacterNoHouseException;
import academy.mindswap.andrecastrosousa.Game;
import academy.mindswap.andrecastrosousa.menu.enums.MenuType;

public class StartCommand implements Command {

    @Override
    public void execute() throws CharacterNoHouseException {
        Game.setMenuType(MenuType.SIM_CREATION_MENU);
    }
}
