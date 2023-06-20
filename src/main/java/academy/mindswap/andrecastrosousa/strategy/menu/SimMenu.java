package academy.mindswap.andrecastrosousa.strategy.menu;

import academy.mindswap.andrecastrosousa.domain.Character;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.factory.MenuCommandsFactory;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;
import academy.mindswap.andrecastrosousa.command.menu.Command;
import academy.mindswap.andrecastrosousa.command.menu.CommandInvoker;
import academy.mindswap.andrecastrosousa.command.menu.navigate.BackCommand;
import academy.mindswap.andrecastrosousa.domain.enums.SimMenuOption;
import academy.mindswap.andrecastrosousa.builder.MenuTerminal;

import java.io.IOException;

public class SimMenu extends MenuBase {

    public SimMenu(CommandInvoker commandInvoker) {
        super(commandInvoker, MenuType.SIM_MENU);
    }

    @Override
    public void handle(Character character) throws IOException, ExitApplication, CharacterNoHouseException, HouseTooDirtyException, NoFundsEnoughtException, BackApplication, CharacterFullBladderException, CharacterNoEnergyException {
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

        if(selectedOption == SimMenuOption.values().length) {
            return new BackCommand();
        } else if(selectedOption >= 0 && selectedOption < SimMenuOption.values().length - 1) {
            return MenuCommandsFactory.fromSimMenu(Integer.parseInt(message) + 1, character);
        } else {
            throw new UnknownCommandException();
        }
    }
}
