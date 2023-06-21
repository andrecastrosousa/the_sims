package academy.mindswap.andrecastrosousa.strategy.menu;

import academy.mindswap.andrecastrosousa.domain.Sim;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;
import academy.mindswap.andrecastrosousa.command.menu.Command;
import academy.mindswap.andrecastrosousa.command.menu.CommandInvoker;

import java.io.IOException;

public abstract class MenuBase implements Menu {
    protected final CommandInvoker commandInvoker;

    protected final MenuType type;

    public MenuBase(MenuType type) {
        this.commandInvoker = new CommandInvoker();
        this.type = type;
    }

    public static Menu buildMenu(MenuType menuType) {
        return switch (menuType) {
            case STARTER_MENU -> new StarterMenu();
            case BUY_HOUSE_MENU -> new HouseMenu();
            case ACTIONS_MENU -> new ActionMenu();
            case SIM_MENU -> new SimMenu();
            case HOUSEKEEPER_MENU -> new HousekeeperMenu();
            case SIM_CREATION_MENU -> new SimCreationMenu();
            case LOAD_GAME_MENU -> new LoadGameMenu();
        };
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
