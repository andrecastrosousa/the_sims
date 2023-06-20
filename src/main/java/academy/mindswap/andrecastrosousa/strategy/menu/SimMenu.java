package academy.mindswap.andrecastrosousa.strategy.menu;

import academy.mindswap.andrecastrosousa.domain.Sim;
import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.factory.MenuCommandsFactory;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;
import academy.mindswap.andrecastrosousa.command.menu.Command;
import academy.mindswap.andrecastrosousa.command.menu.navigate.BackCommand;
import academy.mindswap.andrecastrosousa.domain.enums.SimMenuOption;
import academy.mindswap.andrecastrosousa.builder.MenuTerminal;

import java.io.IOException;

public class SimMenu extends MenuBase {

    public SimMenu() {
        super(MenuType.SIM_MENU);
    }

    @Override
    public void handle() throws IOException, ExitApplication, CharacterNoHouseException, HouseTooDirtyException, NoFundsEnoughtException, BackApplication, CharacterFullBladderException, CharacterNoEnergyException {
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

        if(selectedOption == SimMenuOption.values().length) {
            return new BackCommand();
        } else if(selectedOption >= 0 && selectedOption < SimMenuOption.values().length - 1) {
            return MenuCommandsFactory.fromSimMenu(Integer.parseInt(message) + 1);
        } else {
            throw new UnknownCommandException();
        }
    }

    @Override
    public void back() {
        Game.setMenuType(MenuType.STARTER_MENU);
    }
}
