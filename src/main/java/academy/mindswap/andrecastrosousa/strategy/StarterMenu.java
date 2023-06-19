package academy.mindswap.andrecastrosousa.strategy;

import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.factory.MenuCommandsFactory;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;
import academy.mindswap.andrecastrosousa.command.menu.CommandInvoker;
import academy.mindswap.andrecastrosousa.builder.MenuTerminal;
import academy.mindswap.andrecastrosousa.domain.Character;
import academy.mindswap.andrecastrosousa.command.menu.Command;
import academy.mindswap.andrecastrosousa.domain.enums.StarterMenuOption;

import java.io.IOException;

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

        if(selectedOption < 0 || selectedOption >= StarterMenuOption.values().length - 1) {
            throw new UnknownCommandException();
        }
        return MenuCommandsFactory.fromStarterMenu(Integer.parseInt(message), character);
    }
}
