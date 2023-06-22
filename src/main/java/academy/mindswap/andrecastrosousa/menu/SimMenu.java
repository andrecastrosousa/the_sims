package academy.mindswap.andrecastrosousa.menu;

import academy.mindswap.andrecastrosousa.Game;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.menu.enums.MenuType;
import academy.mindswap.andrecastrosousa.menu.enums.SimMenuOption;
import academy.mindswap.andrecastrosousa.menu.factory.MenuCommandsFactory;
import academy.mindswap.andrecastrosousa.menu.commands.Command;
import academy.mindswap.andrecastrosousa.menu.commands.navigate.BackCommand;

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
