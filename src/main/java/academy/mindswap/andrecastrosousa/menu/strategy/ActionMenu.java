package academy.mindswap.andrecastrosousa.menu.strategy;

import academy.mindswap.andrecastrosousa.DB.Database;
import academy.mindswap.andrecastrosousa.action.command.ActionCommand;
import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.menu.MenuType;
import academy.mindswap.andrecastrosousa.menu.command.navigate.BackCommand;
import academy.mindswap.andrecastrosousa.menu.command.Command;
import academy.mindswap.andrecastrosousa.menu.command.CommandInvoker;
import academy.mindswap.andrecastrosousa.menu.command.DoActionCommand;
import academy.mindswap.andrecastrosousa.utils.MenuTerminal;

import java.io.IOException;
import java.util.List;

public class ActionMenu extends MenuBase {
    public ActionMenu(CommandInvoker commandInvoker) {
        super(commandInvoker, MenuType.ACTIONS_MENU);
    }

    @Override
    public void handle(Character character) throws IOException, ExitApplication, CharacterNoHouseException, NoFundsEnoughtException, HouseTooDirtyException, BackApplication {
        List<String> options = character.getActions().stream()
                .map(Object::toString)
                .toList();

        MenuTerminal menuTerminal = new MenuTerminal.MenuTerminalBuilder()
                .setOptions(options)
                .hasBackButton()
                .build();

        menuTerminal.print();

        String message = menuTerminal.selectOption();

        try {
            Command command = getValidCommand(message, character, character.getActions());
            commandInvoker.setCommand(command);
        } catch (UnknownCommandException e) {
            handle(character);
        }

        commandInvoker.invoke();
    }

    @Override
    protected Command getValidCommand(String message, Character character) throws UnknownCommandException {
        throw new UnknownCommandException();
    }
}
