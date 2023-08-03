package academy.mindswap.andrecastrosousa.client.menu.commands.navigate;

import academy.mindswap.andrecastrosousa.client.menu.commands.Command;
import academy.mindswap.andrecastrosousa.client.menu.enums.MenuType;
import academy.mindswap.andrecastrosousa.client.menu.factory.MenuFactory;

public class BackCommand implements Command {

    private final MenuType currentMenu;

    public BackCommand(MenuType currentMenu) {
        this.currentMenu = currentMenu;
    }

    @Override
    public void execute() {
        MenuFactory.buildMenu(currentMenu).back();
    }
}
