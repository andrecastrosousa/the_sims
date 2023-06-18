package academy.mindswap.andrecastrosousa.menu;

import academy.mindswap.andrecastrosousa.Messages;
import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.menu.option.BuyHouseMenuOption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HouseMenu implements MenuStrategy {

    @Override
    public boolean canHandle(TerminalInteraction menuFlow) {
        return menuFlow == TerminalInteraction.BUY_HOUSE_MENU;
    }

    @Override
    public int handle(Character character) throws IOException {
        System.out.println(Messages.SEPARATOR);
        for (BuyHouseMenuOption houseMenu: BuyHouseMenuOption.values()) {
            System.out.println(houseMenu.getOption() + " -> " + houseMenu.getHouse());
        }
        System.out.println(Messages.SEPARATOR);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String message = reader.readLine();

        // Command command = execute(Integer.getInteger(message), character);

        return 1;
    }
}
