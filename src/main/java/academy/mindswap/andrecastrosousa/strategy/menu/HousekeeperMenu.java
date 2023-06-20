package academy.mindswap.andrecastrosousa.strategy.menu;

import academy.mindswap.andrecastrosousa.builder.MenuTerminal;
import academy.mindswap.andrecastrosousa.command.menu.CallHousekeeperCommand;
import academy.mindswap.andrecastrosousa.command.menu.Command;
import academy.mindswap.andrecastrosousa.command.menu.CommandInvoker;
import academy.mindswap.andrecastrosousa.command.menu.navigate.BackCommand;
import academy.mindswap.andrecastrosousa.domain.Character;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.utils.Messages;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class HousekeeperMenu extends MenuBase {

    public HousekeeperMenu(CommandInvoker commandInvoker) {
        super(commandInvoker, MenuType.HOUSEKEEPER_MENU);
    }

    @Override
    public void handle(Character character) throws IOException, ExitApplication, CharacterNoHouseException, HouseTooDirtyException, NoFundsEnoughtException, BackApplication, CharacterFullBladderException, CharacterNoEnergyException {
        System.out.println(Messages.SEPARATOR);
        System.out.println("|    Do you want to call housekeeper?         |");
        System.out.println("|            10€ per hour                     |");
        System.out.println("|         1 hour per dirty level              |");
        System.out.println("|                                             |");
        System.out.println("|       1 -> yes            0 -> no           |");
        System.out.println(Messages.SEPARATOR);

        MenuTerminal terminal = new MenuTerminal.MenuTerminalBuilder()
                .build();

        String message = terminal.selectOption();

        try {
            System.out.println("\n" + Messages.SEPARATOR);
            System.out.println("Insert how many hours you want hire housekeeper:");
            String secondMessage = terminal.selectOption();
            System.out.println(Messages.SEPARATOR + "\n");

            Command command = getValidCommand(message + " " + secondMessage, character);
            commandInvoker.setCommand(command);
        } catch (UnknownCommandException e) {
            handle(character);
        }

        commandInvoker.invoke();
    }

    @Override
    protected Command getValidCommand(String message, Character character) throws UnknownCommandException {
        List<Integer> valuesInserted = Arrays.stream(message.split("[ ]+")).map(Integer::parseInt).toList();

        int selectedOption = valuesInserted.get(0);

        if(selectedOption < 0 || selectedOption > 1) {
            throw new UnknownCommandException();
        } else if(selectedOption == 1) {
            return new CallHousekeeperCommand(character, character.getHouse(), valuesInserted.get(1));
        }

        return new BackCommand();
    }
}
