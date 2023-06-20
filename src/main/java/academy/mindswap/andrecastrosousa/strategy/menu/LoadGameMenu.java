package academy.mindswap.andrecastrosousa.strategy.menu;

import academy.mindswap.andrecastrosousa.DB.Database;
import academy.mindswap.andrecastrosousa.builder.MenuTerminal;
import academy.mindswap.andrecastrosousa.command.menu.BuyHouseCommand;
import academy.mindswap.andrecastrosousa.command.menu.Command;
import academy.mindswap.andrecastrosousa.command.menu.CommandInvoker;
import academy.mindswap.andrecastrosousa.command.menu.navigate.BackCommand;
import academy.mindswap.andrecastrosousa.domain.Character;
import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;
import academy.mindswap.andrecastrosousa.domain.enums.SimMenuOption;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.singleton.LoadGameSystem;

import java.io.IOException;
import java.util.List;

public class LoadGameMenu extends MenuBase {
    public LoadGameMenu() {
        super(MenuType.LOAD_GAME_MENU);
    }

    @Override
    public void handle(Character character) throws IOException, ExitApplication, CharacterNoHouseException, HouseTooDirtyException, NoFundsEnoughtException, BackApplication, CharacterFullBladderException, CharacterNoEnergyException {
        LoadGameSystem loadGameMenu = LoadGameSystem.getInstance();

        MenuTerminal menuTerminal = new MenuTerminal.Builder()
                .setOptions(loadGameMenu.getLoadGameOptions())
                .hasBackButton()
                .build();

        menuTerminal.print();

        String message = menuTerminal.selectOption();

        try {
            commandInvoker.setCommand(getValidCommand(message, character));
        } catch (UnknownCommandException e) {
            handle(character);
        }

        commandInvoker.invoke();
    }

    @Override
    protected Command getValidCommand(String message, Character character) throws UnknownCommandException {
        LoadGameSystem loadGameMenu = LoadGameSystem.getInstance();

        int selectedOption = Integer.parseInt(message);

        if(selectedOption == loadGameMenu.getLoadGameOptions().size()) {
            return new BackCommand();
        } else if(selectedOption >= 0 && selectedOption < loadGameMenu.getLoadGameOptions().size()) {
            return new BuyHouseCommand(character, Database.houses.get(selectedOption));
        } else {
            throw new UnknownCommandException();
        }
    }

    @Override
    public void back() {
        Game.setMenuType(MenuType.STARTER_MENU);
    }
}
