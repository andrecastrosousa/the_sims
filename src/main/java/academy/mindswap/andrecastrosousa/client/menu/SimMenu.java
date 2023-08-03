package academy.mindswap.andrecastrosousa.client.menu;

import academy.mindswap.andrecastrosousa.Game;
import academy.mindswap.andrecastrosousa.client.exceptions.*;
import academy.mindswap.andrecastrosousa.client.menu.commands.Command;
import academy.mindswap.andrecastrosousa.client.menu.enums.MenuType;
import academy.mindswap.andrecastrosousa.client.menu.enums.SimMenuOption;
import academy.mindswap.andrecastrosousa.client.menu.factory.MenuCommandsFactory;
import academy.mindswap.andrecastrosousa.client.menu.commands.navigate.BackCommand;

import java.io.IOException;

public class SimMenu extends MenuBase {

    public SimMenu() {
        super(MenuType.SIM_MENU);
    }

    @Override
    public void handle() throws IOException, CharacterNoHouseException, HouseTooDirtyException, NoFundsEnoughtException, CharacterFullBladderException, CharacterNoEnergyException {
        MenuTerminal menuTerminal = new MenuTerminal.Builder()
                .setOptions(SimMenuOption.getMenuOptions())
                .hasBackButton()
                .build();

        menuTerminal.print();

        String message = menuTerminal.selectOption();

        try {
            commandInvoker.setCommand(getValidCommand(message));
        } catch (UnknownCommandException e) {
            handle();
        }

        commandInvoker.invoke();
    }

    @Override
    protected Command getValidCommand(String message) throws UnknownCommandException {
        int selectedOption = Integer.parseInt(message);

        if (selectedOption == SimMenuOption.getNumberOfOptions()) {
            return new BackCommand(type);
        }
        return MenuCommandsFactory.fromSimMenu(Integer.parseInt(message) + 1);
    }

    @Override
    public void back() {
        Game.setMenuType(MenuType.STARTER_MENU);
        Game.setSim(null);
    }
}
