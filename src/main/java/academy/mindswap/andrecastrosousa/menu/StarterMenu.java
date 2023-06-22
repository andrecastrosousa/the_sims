package academy.mindswap.andrecastrosousa.menu;

import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.menu.enums.MenuType;
import academy.mindswap.andrecastrosousa.menu.enums.StarterMenuOption;
import academy.mindswap.andrecastrosousa.menu.factory.MenuCommandsFactory;
import academy.mindswap.andrecastrosousa.menu.commands.Command;

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
