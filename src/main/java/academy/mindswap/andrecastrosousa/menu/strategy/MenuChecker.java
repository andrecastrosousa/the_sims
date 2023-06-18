package academy.mindswap.andrecastrosousa.menu.strategy;

import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoHouseException;
import academy.mindswap.andrecastrosousa.exceptions.ExitApplication;
import academy.mindswap.andrecastrosousa.exceptions.NoFundsEnoughtException;
import academy.mindswap.andrecastrosousa.menu.TerminalInteraction;
import academy.mindswap.andrecastrosousa.menu.command.CommandInvoker;
import shaded_package.org.checkerframework.checker.units.qual.A;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Design Pattern: STRATEGY
 */
public class MenuChecker {

    private final List<MenuStrategy> menus;

    public MenuChecker() {
        CommandInvoker commandInvoker = new CommandInvoker();

        menus = new ArrayList<>(List.of(
                new StarterMenu(commandInvoker),
                new HouseMenu(commandInvoker),
                new ActionMenu(commandInvoker)
        ));
    }

    public void showMenu(TerminalInteraction interaction, Character character) throws IOException, ExitApplication, CharacterNoHouseException, NoFundsEnoughtException {
        for (MenuStrategy menuStrategy: menus) {
            if(menuStrategy.canHandle(interaction)) {
                menuStrategy.handle(character);
            }
        }
    }
}
