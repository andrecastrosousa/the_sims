package academy.mindswap.andrecastrosousa.menu.strategy;

import academy.mindswap.andrecastrosousa.DB.Database;
import academy.mindswap.andrecastrosousa.action.command.ActionCommand;
import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.factory.MenuCommandsFactory;
import academy.mindswap.andrecastrosousa.menu.MenuType;
import academy.mindswap.andrecastrosousa.menu.command.BuyHouseCommand;
import academy.mindswap.andrecastrosousa.menu.command.Command;
import academy.mindswap.andrecastrosousa.menu.command.CommandInvoker;
import academy.mindswap.andrecastrosousa.menu.command.DoActionCommand;
import academy.mindswap.andrecastrosousa.menu.command.navigate.BackCommand;
import academy.mindswap.andrecastrosousa.menu.option.SimMenuOption;
import academy.mindswap.andrecastrosousa.utils.MenuTerminal;

import java.io.IOException;
import java.util.List;

public abstract class MenuBase implements Menu {
    protected final CommandInvoker commandInvoker;

    protected final MenuType type;

    public MenuBase(CommandInvoker commandInvoker, MenuType type) {
        this.commandInvoker = commandInvoker;
        this.type = type;
    }

    @Override
    public boolean canHandle(MenuType type) {
        return this.type == type;
    }

    @Override
    public abstract void handle(Character character) throws IOException, ExitApplication, CharacterNoHouseException, HouseTooDirtyException, NoFundsEnoughtException, BackApplication;

    protected abstract Command getValidCommand(String message, Character character) throws UnknownCommandException;

    protected Command getValidCommand(String message, Character character, List<ActionCommand> commands) throws UnknownCommandException {
        int selectedOption = Integer.parseInt(message);

        if(selectedOption == Database.houses.size()) {
            return new BackCommand();
        } else if(selectedOption >= 0 && selectedOption < Database.houses.size()) {
            return new DoActionCommand(character, commands.get(selectedOption));
        } else {
            throw new UnknownCommandException();
        }
    };
}
