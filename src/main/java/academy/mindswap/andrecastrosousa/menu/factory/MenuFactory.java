package academy.mindswap.andrecastrosousa.menu.factory;

import academy.mindswap.andrecastrosousa.menu.enums.MenuType;
import academy.mindswap.andrecastrosousa.menu.*;

public class MenuFactory {
    private MenuFactory(){}

    public static Menu buildMenu(MenuType menuType) {
        return switch (menuType) {
            case STARTER_MENU -> new StarterMenu();
            case BUY_HOUSE_MENU -> new HouseMenu();
            case ACTIONS_MENU -> new ActionMenu();
            case SIM_MENU -> new SimMenu();
            case HOUSEKEEPER_MENU -> new HousekeeperMenu();
            case SIM_CREATION_MENU -> new SimCreationMenu();
            case LOAD_GAME_MENU -> new LoadGameMenu();
            case DIVISION_MENU -> new DivisionMenu();
        };
    }
}
