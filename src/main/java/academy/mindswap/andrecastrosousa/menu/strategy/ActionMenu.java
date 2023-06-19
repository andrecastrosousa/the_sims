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
        System.out.println(Messages.SEPARATOR);
        List<Division> divisions = character.getHouse().getDivisions();

        List<ActionCommand> commands = new java.util.ArrayList<>(divisions.stream()
                .map(Division::getAction)
                .toList());

        commands.addAll(ActionType.getActionsWithoutDivisions().stream()
                .map(a -> a.getAction(character.getNeeds()))
                .toList()
        );

        for (int i = 0; i < commands.size(); i++) {
            System.out.printf(Messages.MENU_OPTION, i, commands.get(i).toString());
        }
        System.out.printf(Messages.MENU_OPTION, commands.size(), Messages.BACK_COMMAND);
        System.out.println(Messages.SEPARATOR);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String message = reader.readLine();

        try {
            Command command = getValidCommand(message, character, commands);
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
