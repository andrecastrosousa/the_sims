package academy.mindswap.andrecastrosousa.client.menu.commands.navigate;

import academy.mindswap.andrecastrosousa.Game;
import academy.mindswap.andrecastrosousa.client.menu.enums.MenuType;
import academy.mindswap.andrecastrosousa.client.menu.commands.Command;

public class GoToActionCommand implements Command {

    @Override
    public void execute() {
        Game.setMenuType(MenuType.ACTIONS_MENU);
    }
}
