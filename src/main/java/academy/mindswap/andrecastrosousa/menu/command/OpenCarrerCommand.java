package academy.mindswap.andrecastrosousa.menu.command;

import academy.mindswap.andrecastrosousa.game.Game;
import academy.mindswap.andrecastrosousa.menu.MenuType;

public class OpenCarrerCommand implements Command {
    @Override
    public void execute() {
        Game.setMenuType(MenuType.BUY_HOUSE_MENU);
    }
}
