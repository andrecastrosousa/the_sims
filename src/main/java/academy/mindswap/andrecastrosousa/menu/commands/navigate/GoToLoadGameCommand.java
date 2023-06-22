package academy.mindswap.andrecastrosousa.menu.commands.navigate;

import academy.mindswap.andrecastrosousa.Game;
import academy.mindswap.andrecastrosousa.menu.enums.MenuType;
import academy.mindswap.andrecastrosousa.menu.commands.Command;

public class GoToLoadGameCommand implements Command {
    @Override
    public void execute() {
        Game.setMenuType(MenuType.LOAD_GAME_MENU);
    }
}
