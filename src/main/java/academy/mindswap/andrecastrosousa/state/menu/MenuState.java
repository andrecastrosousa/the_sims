package academy.mindswap.andrecastrosousa.state.menu;

import academy.mindswap.andrecastrosousa.domain.enums.MenuType;

public abstract class MenuState implements MenuStateI {

    public void back() {};

    public static MenuState buildMenuState(MenuType menuType) {
        return switch (menuType) {
            case STARTER_MENU -> new StarterMenuState();
            case BUY_HOUSE_MENU -> new HouseMenuState();
            case ACTIONS_MENU -> new ActionMenuState();
            case SIM_MENU -> new SimMenuState();
            case HOUSEKEEPER_MENU -> new HousekeeperMenuState();
        };
    }
}
