package academy.mindswap.andrecastrosousa.menu;

import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoHouseException;
import academy.mindswap.andrecastrosousa.exceptions.ExitApplication;
import academy.mindswap.andrecastrosousa.exceptions.NoFundsEnoughtException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuChecker {

    private final List<MenuStrategy> menus;

    public MenuChecker() {
        menus = new ArrayList<>(List.of(
                new StarterMenu(),
                new HouseMenu()
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
