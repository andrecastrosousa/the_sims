package academy.mindswap.andrecastrosousa.strategy.menu;

import academy.mindswap.andrecastrosousa.domain.Sim;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Design Pattern: STRATEGY
 */
public class MenuChecker {

    private final List<Menu> menus;

    public MenuChecker() {
        menus = new ArrayList<>(List.of(
                new StarterMenu(),
                new HouseMenu(),
                new ActionMenu(),
                new SimMenu(),
                new HousekeeperMenu(),
                new LoadGameMenu()
        ));
    }

    public void showMenu(MenuType interaction) throws IOException, ExitApplication, CharacterNoHouseException, NoFundsEnoughtException, HouseTooDirtyException, BackApplication, CharacterFullBladderException, CharacterNoEnergyException {
        for (Menu menu : menus) {
            if(menu.canHandle(interaction)) {
                menu.handle();
            }
        }
    }
}
