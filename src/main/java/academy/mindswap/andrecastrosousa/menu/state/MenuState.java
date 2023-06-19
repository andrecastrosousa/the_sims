package academy.mindswap.andrecastrosousa.menu.state;

import academy.mindswap.andrecastrosousa.exceptions.UnknownCommandException;
import academy.mindswap.andrecastrosousa.menu.MenuType;
import academy.mindswap.andrecastrosousa.menu.strategy.StarterMenu;

public abstract class MenuState implements MenuStateI {

    public void back() {};

    public static MenuState buildMenuState(MenuType menuType) {
        return switch (menuType) {
            case STARTER_MENU -> new StarterMenuState();
            case BUY_HOUSE_MENU -> new HouseMenuState();
            case ACTIONS_MENU -> new ActionMenuState();
        };
    }
}
