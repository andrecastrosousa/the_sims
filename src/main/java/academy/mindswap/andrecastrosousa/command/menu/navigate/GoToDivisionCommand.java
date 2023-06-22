package academy.mindswap.andrecastrosousa.command.menu.navigate;

import academy.mindswap.andrecastrosousa.command.menu.Command;
import academy.mindswap.andrecastrosousa.composite.Division;
import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;
import academy.mindswap.andrecastrosousa.exceptions.*;

public class GoToDivisionCommand implements Command {

    private final Division division;

    public GoToDivisionCommand(Division division) {
        this.division = division;
    }

    @Override
    public void execute() throws NoFundsEnoughtException, CharacterNoHouseException, HouseTooDirtyException, CharacterFullBladderException, CharacterNoEnergyException {
        Game.getSim().goToDivision(division);
        Game.setMenuType(MenuType.ACTIONS_MENU);
    }
}
