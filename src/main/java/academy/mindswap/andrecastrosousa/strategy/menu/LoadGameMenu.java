package academy.mindswap.andrecastrosousa.strategy.menu;

import academy.mindswap.andrecastrosousa.builder.MenuTerminal;
import academy.mindswap.andrecastrosousa.command.menu.Command;
import academy.mindswap.andrecastrosousa.command.menu.LoadGameCommand;
import academy.mindswap.andrecastrosousa.command.menu.navigate.BackCommand;
import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.singleton.LoadGameSystem;

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
        } else if(selectedOption >= 0 && selectedOption < loadGameMenu.getNumberOfGamesSaved()) {
            return new LoadGameCommand(loadGameMenu.getSavedFile(selectedOption));
        }
        throw new UnknownCommandException();
    }

    @Override
    public void back() {
        Game.setMenuType(MenuType.STARTER_MENU);
    }
}
