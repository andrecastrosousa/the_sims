package academy.mindswap.andrecastrosousa.client.menu.commands.navigate;

import academy.mindswap.andrecastrosousa.Game;
import academy.mindswap.andrecastrosousa.client.exceptions.*;
import academy.mindswap.andrecastrosousa.client.menu.commands.Command;
import academy.mindswap.andrecastrosousa.client.menu.enums.MenuType;
import academy.mindswap.andrecastrosousa.server.models.Division;

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
