package academy.mindswap.andrecastrosousa.client.menu;

import academy.mindswap.andrecastrosousa.Game;
import academy.mindswap.andrecastrosousa.client.exceptions.*;
import academy.mindswap.andrecastrosousa.client.menu.commands.Command;
import academy.mindswap.andrecastrosousa.client.menu.commands.navigate.BackCommand;
import academy.mindswap.andrecastrosousa.client.menu.enums.MenuType;
import academy.mindswap.andrecastrosousa.client.menu.factory.MenuCommandsFactory;
import academy.mindswap.andrecastrosousa.LoadGameSystem;

import java.io.IOException;

public class LoadGameMenu extends MenuBase {
    public LoadGameMenu() {
        super(MenuType.LOAD_GAME_MENU);
    }

    @Override
    public void handle() throws IOException, CharacterNoHouseException, HouseTooDirtyException, NoFundsEnoughtException, CharacterFullBladderException, CharacterNoEnergyException {
        LoadGameSystem loadGameMenu = LoadGameSystem.getInstance();

        MenuTerminal menuTerminal = new MenuTerminal.Builder()
                .setOptions(loadGameMenu.getLoadGameOptions())
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
        LoadGameSystem loadGameMenu = LoadGameSystem.getInstance();

        int selectedOption = Integer.parseInt(message);

        if(selectedOption == loadGameMenu.getNumberOfGamesSaved()) {
            return new BackCommand(type);
        }

        return MenuCommandsFactory.fromLoadGameMenu(selectedOption);
    }

    @Override
    public void back() {
        Game.setMenuType(MenuType.STARTER_MENU);
    }
}
