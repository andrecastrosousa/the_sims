package academy.mindswap.andrecastrosousa.menu.strategy;

import academy.mindswap.andrecastrosousa.DB.Database;
import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.factory.MenuCommandsFactory;
import academy.mindswap.andrecastrosousa.menu.MenuType;
import academy.mindswap.andrecastrosousa.menu.command.BuyHouseCommand;
import academy.mindswap.andrecastrosousa.menu.command.Command;
import academy.mindswap.andrecastrosousa.menu.command.CommandInvoker;
import academy.mindswap.andrecastrosousa.menu.command.navigate.BackCommand;
import academy.mindswap.andrecastrosousa.menu.option.SimMenuOption;
import academy.mindswap.andrecastrosousa.menu.option.StarterMenuOption;
import academy.mindswap.andrecastrosousa.utils.MenuTerminal;

import java.io.IOException;

public class SimMenu extends MenuBase {

    public SimMenu(CommandInvoker commandInvoker) {
        super(commandInvoker, MenuType.SIM_MENU);
    }

    @Override
    public void handle(Character character) throws IOException, ExitApplication, CharacterNoHouseException, HouseTooDirtyException, NoFundsEnoughtException, BackApplication {
        MenuTerminal menuTerminal = new MenuTerminal.MenuTerminalBuilder()
                .setOptions(SimMenuOption.getMenuOptions())
                .hasBackButton()
                .build();

        menuTerminal.print();

        String message = menuTerminal.selectOption();

        try {
            commandInvoker.setCommand(getValidCommand(message, character));
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
        } else if(selectedOption >= 0 && selectedOption < SimMenuOption.values().length - 1) {
            return MenuCommandsFactory.fromSimMenu(Integer.parseInt(message) + 1, character);
        } else {
            throw new UnknownCommandException();
        }
    }
}
