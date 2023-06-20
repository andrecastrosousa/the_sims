package academy.mindswap.andrecastrosousa.strategy.menu;

import academy.mindswap.andrecastrosousa.domain.Character;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;
import academy.mindswap.andrecastrosousa.command.menu.CommandInvoker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Design Pattern: STRATEGY
 */
public class MenuChecker {

    private final List<Menu> menus;

    public MenuChecker() {
        CommandInvoker commandInvoker = new CommandInvoker();

        menus = new ArrayList<>(List.of(
                new StarterMenu(commandInvoker),
                new HouseMenu(commandInvoker),
                new ActionMenu(commandInvoker),
                new SimMenu(commandInvoker),
                new HousekeeperMenu(commandInvoker)
        ));
    }

    public void showMenu(MenuType interaction, Character character) throws IOException, ExitApplication, CharacterNoHouseException, NoFundsEnoughtException, HouseTooDirtyException, BackApplication, CharacterFullBladderException, CharacterNoEnergyException {
        for (Menu menu : menus) {
            if(menu.canHandle(interaction)) {
                menu.handle(character);
            }
        }
    }
}
