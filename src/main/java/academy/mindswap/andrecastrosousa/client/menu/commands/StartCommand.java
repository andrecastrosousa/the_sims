package academy.mindswap.andrecastrosousa.client.menu.commands;

import academy.mindswap.andrecastrosousa.client.exceptions.CharacterNoHouseException;
import academy.mindswap.andrecastrosousa.Game;
import academy.mindswap.andrecastrosousa.client.menu.enums.MenuType;

public class StartCommand implements Command {

    @Override
    public void execute() throws CharacterNoHouseException {
        Game.setMenuType(MenuType.SIM_CREATION_MENU);
    }
}
