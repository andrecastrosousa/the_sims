package academy.mindswap.andrecastrosousa.strategy.menu;

import academy.mindswap.andrecastrosousa.command.menu.Command;
import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.Sim;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;
import academy.mindswap.andrecastrosousa.exceptions.*;

import java.io.IOException;

public class SimCreationMenu extends MenuBase {
    public SimCreationMenu() {
        super(MenuType.SIM_CREATION_MENU);
    }

    @Override
    public void handle() throws IOException, ExitApplication, CharacterNoHouseException, HouseTooDirtyException, NoFundsEnoughtException, BackApplication, CharacterFullBladderException, CharacterNoEnergyException {

    }

    @Override
    protected Command getValidCommand(String message) throws UnknownCommandException {
        return null;
    }

    @Override
    public void back() {
        Game.setMenuType(MenuType.STARTER_MENU);
    }
}
