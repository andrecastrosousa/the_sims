package academy.mindswap.andrecastrosousa.menu;

import academy.mindswap.andrecastrosousa.Messages;
import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.menu.option.StarterMenuOption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StarterMenu implements MenuStrategy {

    @Override
    public boolean canHandle(TerminalInteraction menuFlow) {
        return menuFlow == TerminalInteraction.STARTER_MENU;
    }

    @Override
    public int handle(Character character) throws IOException {
        System.out.println(Messages.SEPARATOR);
        for (StarterMenuOption starterMenu: StarterMenuOption.values()) {
            System.out.println(starterMenu.getOption() + " -> " + starterMenu.getMessage());
        }
        System.out.println(Messages.SEPARATOR);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String message = reader.readLine();

        // Command command = StarterMenuOption.execute(Integer.getInteger(message), character);

        return 1;
    }
}
