package academy.mindswap.andrecastrosousa.command.menu;

import academy.mindswap.andrecastrosousa.domain.Sim;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoHouseException;
import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;

public class StartCommand implements Command {

    @Override
    public void execute() throws CharacterNoHouseException {
        Sim sim = Game.getSim();

        if(sim.getHouse() == null) {
            throw new CharacterNoHouseException();
        }
        Game.setMenuType(MenuType.SIM_MENU);
    }
}
