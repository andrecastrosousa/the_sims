package academy.mindswap.andrecastrosousa.client.menu;

import academy.mindswap.andrecastrosousa.client.exceptions.*;
import academy.mindswap.andrecastrosousa.client.menu.commands.Command;
import academy.mindswap.andrecastrosousa.client.menu.enums.MenuType;
import academy.mindswap.andrecastrosousa.client.menu.enums.StarterMenuOption;
import academy.mindswap.andrecastrosousa.client.menu.factory.MenuCommandsFactory;

import java.io.IOException;

public class StarterMenu extends MenuBase {

    public StarterMenu() {
        super(MenuType.STARTER_MENU);
    }

    @Override
    public void handle() throws IOException, CharacterNoHouseException, NoFundsEnoughtException, HouseTooDirtyException, CharacterFullBladderException, CharacterNoEnergyException {
        MenuTerminal menuTerminal = new MenuTerminal.Builder()
                .setOptions(StarterMenuOption.getMenuOptions())
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

        if(selectedOption < 0 || selectedOption >= StarterMenuOption.getNumberOfOptions()) {
            throw new UnknownCommandException();
        }
        return MenuCommandsFactory.fromStarterMenu(Integer.parseInt(message));
    }

    @Override
    public void back() {

    }
}
