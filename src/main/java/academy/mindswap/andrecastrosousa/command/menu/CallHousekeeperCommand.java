package academy.mindswap.andrecastrosousa.command.menu;

import academy.mindswap.andrecastrosousa.domain.Sim;
import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.House;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;
import academy.mindswap.andrecastrosousa.exceptions.*;

import java.util.stream.IntStream;

public class CallHousekeeperCommand implements Command {
    private final int hour;

    public CallHousekeeperCommand(House house, int hour) {
        this.hour = hour;
    }

    @Override
    public void execute() throws NoFundsEnoughtException {
        Sim sim = Game.getSim();

        if(sim.getBalance() - (10 * hour) < 0) {
            throw new NoFundsEnoughtException();
        }

        IntStream.range(0, hour).forEach(h -> {
            try {
                sim.getHouse().decreaseDirtyLevel();
            } catch (HouseAlreadyCleanException ignored) {
            }
        });

        sim.pay(10 * hour);
        Game.setMenuType(MenuType.SIM_MENU);
    }
}
