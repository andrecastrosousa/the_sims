package academy.mindswap.andrecastrosousa.menu.strategy;

import academy.mindswap.andrecastrosousa.DB.Database;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.house.House;
import academy.mindswap.andrecastrosousa.menu.MenuType;
import academy.mindswap.andrecastrosousa.menu.command.*;
import academy.mindswap.andrecastrosousa.menu.command.navigate.BackCommand;
import academy.mindswap.andrecastrosousa.utils.MenuTerminal;
import academy.mindswap.andrecastrosousa.character.Character;

import java.io.IOException;
import java.util.List;

public class HouseMenu extends MenuBase {
    public HouseMenu(CommandInvoker commandInvoker) {
        super(commandInvoker, MenuType.BUY_HOUSE_MENU);
    }

    @Override
    public void handle(Character character) throws IOException, ExitApplication, CharacterNoHouseException, NoFundsEnoughtException, HouseTooDirtyException, BackApplication {

        List<String> options = Database.houses.stream()
                .map(House::toString)
                .toList();

        MenuTerminal menuTerminal = new MenuTerminal.MenuTerminalBuilder()
                .setOptions(options)
                .hasBackButton()
                .build();

        menuTerminal.print();

        String message = menuTerminal.selectOption();


        try {
            Command command = getValidCommand(message, character);
            commandInvoker.setCommand(command);
        } catch (UnknownCommandException e) {
            handle(character);
        }

        commandInvoker.invoke();
    }

    @Override
    protected Command getValidCommand(String message, Character character) throws UnknownCommandException {
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
