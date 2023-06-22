package academy.mindswap.andrecastrosousa.command.menu.navigate;

import academy.mindswap.andrecastrosousa.command.menu.Command;
import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;
import academy.mindswap.andrecastrosousa.exceptions.*;

public class GoToDivisionMenuCommand implements Command {
    @Override
    public void execute() throws NoFundsEnoughtException, CharacterNoHouseException, HouseTooDirtyException, CharacterFullBladderException, CharacterNoEnergyException {
        Game.setMenuType(MenuType.DIVISION_MENU);
    }
}
