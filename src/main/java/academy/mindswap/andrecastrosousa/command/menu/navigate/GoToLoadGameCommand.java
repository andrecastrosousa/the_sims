package academy.mindswap.andrecastrosousa.command.menu.navigate;

import academy.mindswap.andrecastrosousa.command.menu.Command;
import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;

public class GoToLoadGameCommand implements Command {
    @Override
    public void execute() {
        Game.setMenuType(MenuType.LOAD_GAME_MENU);
    }
}
