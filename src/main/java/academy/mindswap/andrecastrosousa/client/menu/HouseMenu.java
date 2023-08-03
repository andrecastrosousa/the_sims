package academy.mindswap.andrecastrosousa.client.menu;

import academy.mindswap.andrecastrosousa.server.Database;
import academy.mindswap.andrecastrosousa.client.exceptions.*;
import academy.mindswap.andrecastrosousa.client.menu.commands.Command;
import academy.mindswap.andrecastrosousa.Game;
import academy.mindswap.andrecastrosousa.server.models.House;
import academy.mindswap.andrecastrosousa.client.menu.commands.navigate.BackCommand;
import academy.mindswap.andrecastrosousa.client.menu.enums.MenuType;
import academy.mindswap.andrecastrosousa.client.menu.factory.MenuCommandsFactory;

import java.io.IOException;
import java.util.List;

public class HouseMenu extends MenuBase {
    public HouseMenu() {
        super(MenuType.BUY_HOUSE_MENU);
    }

    @Override
    public void handle() throws IOException, CharacterNoEnergyException, CharacterFullBladderException, CharacterNoHouseException, HouseTooDirtyException, NoFundsEnoughtException {

        /*List<String> options = Database.houses.stream()
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

        commandInvoker.invoke();*/
    }

    @Override
    protected Command getValidCommand(String message) throws UnknownCommandException {
        int selectedOption = Integer.parseInt(message);

        /*if(selectedOption == Database.houses.size()) {
            return new BackCommand(type);
        }*/

        return MenuCommandsFactory.fromHouseMenu(selectedOption);
    }

    @Override
    public void back() {
        Game.setMenuType(MenuType.STARTER_MENU);
    }
}
