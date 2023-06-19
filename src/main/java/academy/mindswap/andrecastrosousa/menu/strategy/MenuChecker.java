package academy.mindswap.andrecastrosousa.menu.strategy;

import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.menu.MenuType;
import academy.mindswap.andrecastrosousa.menu.command.CommandInvoker;

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
                new ActionMenu(commandInvoker)
        ));
    }

    public void showMenu(MenuType interaction, Character character) throws IOException, ExitApplication, CharacterNoHouseException, NoFundsEnoughtException, HouseTooDirtyException, BackApplication {
        for (Menu menu : menus) {
            if(menu.canHandle(interaction)) {
                menu.handle(character);
            }
        }
    }
}
