package academy.mindswap.andrecastrosousa.strategy.menu;

import academy.mindswap.andrecastrosousa.builder.MenuTerminal;
import academy.mindswap.andrecastrosousa.command.menu.Command;
import academy.mindswap.andrecastrosousa.command.menu.navigate.BackCommand;
import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.factory.MenuCommandsFactory;
import academy.mindswap.andrecastrosousa.utils.Messages;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class HousekeeperMenu extends MenuBase {

    public HousekeeperMenu() {
        super(MenuType.HOUSEKEEPER_MENU);
    }

    @Override
    public void handle() throws IOException, CharacterNoEnergyException, CharacterFullBladderException, CharacterNoHouseException, HouseTooDirtyException, NoFundsEnoughtException {

        System.out.println(Messages.HOUSEKEEPER_MESSAGE);

        MenuTerminal terminal = new MenuTerminal.Builder()
                .build();

        String message = terminal.selectOption();

        try {
            System.out.println("\n" + Messages.SEPARATOR);
            System.out.println("Insert how many hours you want hire housekeeper:");
            String secondMessage = terminal.selectOption();
            System.out.println(Messages.SEPARATOR + "\n");

            Command command = getValidCommand(message + " " + secondMessage);
            commandInvoker.setCommand(command);
        } catch (UnknownCommandException e) {
            handle();
        }

        commandInvoker.invoke();
    }

    @Override
    protected Command getValidCommand(String message) throws UnknownCommandException {
        List<Integer> valuesInserted = Arrays.stream(message.split("[ ]+")).map(Integer::parseInt).toList();

        if(valuesInserted.get(0) == 1) {
            return new BackCommand(type);
        }

        return MenuCommandsFactory.fromHousekeeperMenu(valuesInserted.get(0), valuesInserted.get(1));
    }

    @Override
    public void back() {
        Game.setMenuType(MenuType.SIM_MENU);
    }
}
