package academy.mindswap.andrecastrosousa.client.menu.commands.navigate;

import academy.mindswap.andrecastrosousa.Game;
import academy.mindswap.andrecastrosousa.client.menu.commands.Command;
import academy.mindswap.andrecastrosousa.client.menu.enums.MenuType;

public class GoToSimDetailsCommand implements Command {
    @Override
    public void execute() {
        Game.setMenuType(MenuType.BUY_HOUSE_MENU);
    }
}
