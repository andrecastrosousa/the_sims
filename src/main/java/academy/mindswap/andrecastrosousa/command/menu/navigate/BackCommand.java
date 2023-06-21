package academy.mindswap.andrecastrosousa.command.menu.navigate;

import academy.mindswap.andrecastrosousa.command.menu.Command;
import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.strategy.menu.MenuBase;

public class BackCommand implements Command {

    private final MenuType currentMenu;

    public BackCommand(MenuType currentMenu) {
        this.currentMenu = currentMenu;
    }

    @Override
    public void execute() {
        MenuBase.buildMenu(currentMenu).back();
    }
}
