package academy.mindswap.andrecastrosousa.strategy;

import academy.mindswap.andrecastrosousa.domain.Character;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;
import academy.mindswap.andrecastrosousa.command.menu.Command;
import academy.mindswap.andrecastrosousa.command.menu.CommandInvoker;

import java.io.IOException;

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
}
