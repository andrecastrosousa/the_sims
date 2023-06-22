package academy.mindswap.andrecastrosousa.menu;

import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.menu.commands.Command;
import academy.mindswap.andrecastrosousa.menu.commands.CommandInvoker;
import academy.mindswap.andrecastrosousa.menu.enums.MenuType;

import java.io.IOException;

public abstract class MenuBase implements Menu {
    protected final CommandInvoker commandInvoker;

    protected final MenuType type;

    public MenuBase(MenuType type) {
        this.commandInvoker = new CommandInvoker();
        this.type = type;
    }

    @Override
    public boolean canHandle(MenuType type) {
        return this.type == type;
    }

    @Override
    public abstract void handle() throws IOException, CharacterNoHouseException, HouseTooDirtyException, NoFundsEnoughtException, CharacterFullBladderException, CharacterNoEnergyException;

    protected abstract Command getValidCommand(String message) throws UnknownCommandException;

    @Override
    public abstract void back();
}
