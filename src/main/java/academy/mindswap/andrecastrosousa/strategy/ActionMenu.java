package academy.mindswap.andrecastrosousa.strategy;

import academy.mindswap.andrecastrosousa.command.action.ActionCommand;
import academy.mindswap.andrecastrosousa.command.menu.DoActionCommand;
import academy.mindswap.andrecastrosousa.command.navigate.BackCommand;
import academy.mindswap.andrecastrosousa.domain.Character;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;
import academy.mindswap.andrecastrosousa.command.menu.Command;
import academy.mindswap.andrecastrosousa.command.menu.CommandInvoker;
import academy.mindswap.andrecastrosousa.builder.MenuTerminal;

import java.io.IOException;
import java.util.List;

public class ActionMenu extends MenuBase {

    private List<ActionCommand> actions;
    public ActionMenu(CommandInvoker commandInvoker) {
        super(commandInvoker, MenuType.ACTIONS_MENU);
    }

    @Override
    public void handle(Character character) throws IOException, ExitApplication, CharacterNoHouseException, NoFundsEnoughtException, HouseTooDirtyException, BackApplication {
        actions = character.getActions();
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

        if(selectedOption == actions.size()) {
            return new BackCommand();
        } else if(selectedOption >= 0 && selectedOption < actions.size()) {
            return new DoActionCommand(character, character.getHouse().getDivisions().get(selectedOption));
        } else {
            throw new UnknownCommandException();
        }
    }
}
