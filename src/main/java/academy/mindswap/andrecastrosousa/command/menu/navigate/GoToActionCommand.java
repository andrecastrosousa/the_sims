package academy.mindswap.andrecastrosousa.command.menu.navigate;

import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;
import academy.mindswap.andrecastrosousa.command.menu.Command;

public class GoToActionCommand implements Command {

    @Override
    public void execute() {
        Game.setMenuType(MenuType.ACTIONS_MENU);
    }
}
