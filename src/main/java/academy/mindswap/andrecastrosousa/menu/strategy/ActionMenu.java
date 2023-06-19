package academy.mindswap.andrecastrosousa.menu.strategy;

import academy.mindswap.andrecastrosousa.DB.Database;
import academy.mindswap.andrecastrosousa.action.command.ActionCommand;
import academy.mindswap.andrecastrosousa.action.command.ActionType;
import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.house.Division;
import academy.mindswap.andrecastrosousa.menu.MenuType;
import academy.mindswap.andrecastrosousa.menu.command.BackCommand;
import academy.mindswap.andrecastrosousa.menu.command.Command;
import academy.mindswap.andrecastrosousa.menu.command.CommandInvoker;
import academy.mindswap.andrecastrosousa.menu.command.DoActionCommand;
import academy.mindswap.andrecastrosousa.menu.option.StarterMenuOption;
import academy.mindswap.andrecastrosousa.utils.MenuTerminal;
import academy.mindswap.andrecastrosousa.utils.Messages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ActionMenu implements Menu {
    CommandInvoker commandInvoker;

    public ActionMenu(CommandInvoker commandInvoker) {
        this.commandInvoker = commandInvoker;
    }

    @Override
    public boolean canHandle(MenuType menuFlow) {
        return menuFlow == MenuType.ACTIONS_MENU;
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

    private Command getValidCommand(String message, Character character, List<ActionCommand> commands) throws UnknownCommandException {
        int selectedOption = Integer.parseInt(message);

        if(selectedOption == Database.houses.size()) {
            return new BackCommand();
        } else if(selectedOption >= 0 && selectedOption < Database.houses.size()) {
            return new DoActionCommand(character, commands.get(selectedOption));
        } else {
            throw new UnknownCommandException();
        }
    }
}
