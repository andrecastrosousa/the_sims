package academy.mindswap.andrecastrosousa.client.menu.commands.navigate;

import academy.mindswap.andrecastrosousa.Game;
import academy.mindswap.andrecastrosousa.client.exceptions.*;
import academy.mindswap.andrecastrosousa.client.menu.commands.Command;
import academy.mindswap.andrecastrosousa.client.menu.enums.MenuType;

public class GoToDivisionMenuCommand implements Command {
    @Override
    public void execute() throws NoFundsEnoughtException, CharacterNoHouseException, HouseTooDirtyException, CharacterFullBladderException, CharacterNoEnergyException {
        Game.setMenuType(MenuType.DIVISION_MENU);
    }
}
