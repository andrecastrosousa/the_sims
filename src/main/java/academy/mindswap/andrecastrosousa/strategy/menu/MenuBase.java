package academy.mindswap.andrecastrosousa.strategy.menu;

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

    public static Menu buildMenuState(MenuType menuType) {
        return switch (menuType) {
            case STARTER_MENU -> new StarterMenu(new CommandInvoker());
            case BUY_HOUSE_MENU -> new HouseMenu(new CommandInvoker());
            case ACTIONS_MENU -> new ActionMenu(new CommandInvoker());
            case SIM_MENU -> new SimMenu(new CommandInvoker());
            case HOUSEKEEPER_MENU -> new HousekeeperMenu(new CommandInvoker());
        };
    }

    @Override
    public boolean canHandle(MenuType type) {
        return this.type == type;
    }

    @Override
    public abstract void handle(Character character) throws IOException, ExitApplication, CharacterNoHouseException, HouseTooDirtyException, NoFundsEnoughtException, BackApplication, CharacterFullBladderException, CharacterNoEnergyException;

    protected abstract Command getValidCommand(String message, Character character) throws UnknownCommandException;

    @Override
    public void back(){}
}
