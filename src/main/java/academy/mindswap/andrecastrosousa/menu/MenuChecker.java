package academy.mindswap.andrecastrosousa.menu;

import academy.mindswap.andrecastrosousa.character.Character;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuChecker {

    private final List<MenuStrategy> menus;

    public MenuChecker() {
        menus = new ArrayList<>(List.of(
           new StarterMenu()
        ));
    }

    public void showMenu(TerminalInteraction interaction, Character character) throws IOException {
        for (MenuStrategy menuStrategy: menus) {
            if(menuStrategy.canHandle(interaction)) {
                menuStrategy.handle(character);
            }
        }
    }
}
