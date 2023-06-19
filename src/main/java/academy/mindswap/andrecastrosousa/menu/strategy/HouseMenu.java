package academy.mindswap.andrecastrosousa.menu.strategy;

import academy.mindswap.andrecastrosousa.DB.Database;
import academy.mindswap.andrecastrosousa.action.command.ActionCommand;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.menu.MenuType;
import academy.mindswap.andrecastrosousa.menu.command.*;
import academy.mindswap.andrecastrosousa.utils.Messages;
import academy.mindswap.andrecastrosousa.character.Character;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class HouseMenu implements Menu {

    CommandInvoker commandInvoker;

    public HouseMenu(CommandInvoker commandInvoker) {
        this.commandInvoker = commandInvoker;
    }

    @Override
    public boolean canHandle(MenuType menuFlow) {
        return menuFlow == MenuType.BUY_HOUSE_MENU;
    }

    @Override
    public void handle(Character character) throws IOException, ExitApplication, CharacterNoHouseException, NoFundsEnoughtException, HouseTooDirtyException, BackApplication {
        System.out.println(Messages.SEPARATOR);
        for (int i = 0; i < Database.houses.size(); i++) {
            System.out.printf(Messages.MENU_OPTION, i, Database.houses.get(i));
        }
        System.out.printf(Messages.MENU_OPTION, Database.houses.size(), Messages.BACK_COMMAND);
        System.out.println(Messages.SEPARATOR);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String message = reader.readLine();


        try {
            Command command = getValidCommand(message, character);
            commandInvoker.setCommand(command);
        } catch (UnknownCommandException e) {
            handle(character);
        }

        commandInvoker.invoke();
    }

    private Command getValidCommand(String message, Character character) throws UnknownCommandException {
        int selectedOption = Integer.parseInt(message);

        if(selectedOption == Database.houses.size()) {
            return new BackCommand();
        } else if(selectedOption >= 0 && selectedOption < Database.houses.size()) {
            return new BuyHouseCommand(character, Database.houses.get(selectedOption));
        } else {
            throw new UnknownCommandException();
        }
    }
}
