package academy.mindswap.andrecastrosousa.menu;

import academy.mindswap.andrecastrosousa.DB.Database;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.menu.commands.Command;
import academy.mindswap.andrecastrosousa.Game;
import academy.mindswap.andrecastrosousa.house.House;
import academy.mindswap.andrecastrosousa.menu.commands.navigate.BackCommand;
import academy.mindswap.andrecastrosousa.menu.enums.MenuType;
import academy.mindswap.andrecastrosousa.menu.factory.MenuCommandsFactory;

import java.io.IOException;
import java.util.List;

public class HouseMenu extends MenuBase {
    public HouseMenu() {
        super(MenuType.BUY_HOUSE_MENU);
    }

    @Override
    public void handle() throws IOException, CharacterNoEnergyException, CharacterFullBladderException, CharacterNoHouseException, HouseTooDirtyException, NoFundsEnoughtException {

        List<String> options = Database.houses.stream()
                .map(House::toString)
                .toList();

        MenuTerminal menuTerminal = new MenuTerminal.Builder()
                .setOptions(options)
                .hasBackButton()
                .build();

        menuTerminal.print();

        String message = menuTerminal.selectOption();

        try {
            Command command = getValidCommand(message);
            commandInvoker.setCommand(command);
        } catch (UnknownCommandException e) {
            handle();
        }

        commandInvoker.invoke();
    }

    @Override
    protected Command getValidCommand(String message) throws UnknownCommandException {
        int selectedOption = Integer.parseInt(message);

        if(selectedOption == Database.houses.size()) {
            return new BackCommand(type);
        }

        return MenuCommandsFactory.fromHouseMenu(selectedOption);
    }

    @Override
    public void back() {
        Game.setMenuType(MenuType.STARTER_MENU);
    }
}
