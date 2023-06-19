package academy.mindswap.andrecastrosousa.menu.command.navigate;

import academy.mindswap.andrecastrosousa.game.Game;
import academy.mindswap.andrecastrosousa.menu.MenuType;
import academy.mindswap.andrecastrosousa.menu.command.Command;

public class GoToActionCommand implements Command {

    @Override
    public void execute() {
        Game.setMenuType(MenuType.ACTIONS_MENU);
    }
}
