package academy.mindswap.andrecastrosousa.strategy.menu;

import academy.mindswap.andrecastrosousa.command.menu.DoActionCommand;
import academy.mindswap.andrecastrosousa.command.menu.navigate.BackCommand;
import academy.mindswap.andrecastrosousa.domain.Character;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;
import academy.mindswap.andrecastrosousa.command.menu.Command;
import academy.mindswap.andrecastrosousa.command.menu.CommandInvoker;
import academy.mindswap.andrecastrosousa.builder.MenuTerminal;
import academy.mindswap.andrecastrosousa.utils.Messages;

import java.io.IOException;
import java.util.List;

public class ActionMenu extends MenuBase {

    public ActionMenu(CommandInvoker commandInvoker) {
        super(commandInvoker, MenuType.ACTIONS_MENU);
    }

    @Override
    public void handle(Character character) throws IOException, ExitApplication, CharacterNoHouseException, NoFundsEnoughtException, HouseTooDirtyException, BackApplication, CharacterFullBladderException, CharacterNoEnergyException {
        List<String> options = character.getHouse().getDivisions().stream()
                .map(d -> String.format(Messages.GO_TO_COMMAND, d.getName(), d.getAction().toString()))
                .toList();

        System.out.println("Level of cleanness: " + character.getHouse().getDirtyLevel());

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

        if(selectedOption == character.getHouse().getDivisions().size()) {
            return new BackCommand();
        } else if(selectedOption >= 0 && selectedOption < character.getHouse().getDivisions().size()) {
            return new DoActionCommand(character, character.getHouse().getDivisions().get(selectedOption));
        } else {
            throw new UnknownCommandException();
        }
    }
}
