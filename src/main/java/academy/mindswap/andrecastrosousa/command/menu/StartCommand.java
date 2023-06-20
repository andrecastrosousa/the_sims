package academy.mindswap.andrecastrosousa.command.menu;

import academy.mindswap.andrecastrosousa.domain.Sim;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoHouseException;
import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;

public class StartCommand implements Command {
    private final Sim sim;

    public StartCommand(Sim sim) {
        this.sim = sim;
    }

    @Override
    public void execute() throws CharacterNoHouseException {
        if(sim.getHouse() == null) {
            throw new CharacterNoHouseException();
        }
        Game.setMenuType(MenuType.SIM_MENU);
    }
}
