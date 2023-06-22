package academy.mindswap.andrecastrosousa.menu.commands.navigate;

import academy.mindswap.andrecastrosousa.Game;
import academy.mindswap.andrecastrosousa.menu.enums.MenuType;
import academy.mindswap.andrecastrosousa.menu.commands.Command;

public class GoToSimDetailsCommand implements Command {
    @Override
    public void execute() {
        Game.setMenuType(MenuType.BUY_HOUSE_MENU);
    }
}
