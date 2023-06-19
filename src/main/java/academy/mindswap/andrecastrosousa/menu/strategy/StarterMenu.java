package academy.mindswap.andrecastrosousa.menu.strategy;

import academy.mindswap.andrecastrosousa.DB.Database;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.factory.MenuCommandsFactory;
import academy.mindswap.andrecastrosousa.menu.MenuType;
import academy.mindswap.andrecastrosousa.menu.command.CommandInvoker;
import academy.mindswap.andrecastrosousa.menu.command.navigate.BackCommand;
import academy.mindswap.andrecastrosousa.menu.option.SimMenuOption;
import academy.mindswap.andrecastrosousa.utils.MenuTerminal;
import academy.mindswap.andrecastrosousa.utils.Messages;
import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.menu.command.Command;
import academy.mindswap.andrecastrosousa.menu.option.StarterMenuOption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class StarterMenu extends MenuBase {

    public StarterMenu(CommandInvoker commandInvoker) {
        super(commandInvoker, MenuType.STARTER_MENU);
    }

    @Override
    public void handle(Character character) throws IOException, ExitApplication, CharacterNoHouseException, NoFundsEnoughtException, HouseTooDirtyException, BackApplication {
        MenuTerminal menuTerminal = new MenuTerminal.MenuTerminalBuilder()
                .setOptions(StarterMenuOption.getMenuOptions())
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
        } else if(selectedOption >= 0 && selectedOption < StarterMenuOption.values().length - 1) {
            return MenuCommandsFactory.fromStarterMenu(Integer.parseInt(message) + 1, character);
        } else {
            throw new UnknownCommandException();
        }
    }
}
