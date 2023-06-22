package academy.mindswap.andrecastrosousa.menu.commands.navigate;

import academy.mindswap.andrecastrosousa.Game;
import academy.mindswap.andrecastrosousa.menu.enums.MenuType;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.menu.commands.Command;

public class GoToDivisionMenuCommand implements Command {
    @Override
    public void execute() throws NoFundsEnoughtException, CharacterNoHouseException, HouseTooDirtyException, CharacterFullBladderException, CharacterNoEnergyException {
        Game.setMenuType(MenuType.DIVISION_MENU);
    }
}
