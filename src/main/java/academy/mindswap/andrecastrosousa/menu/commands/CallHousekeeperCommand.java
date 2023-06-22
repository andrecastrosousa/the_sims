package academy.mindswap.andrecastrosousa.menu.commands;

import academy.mindswap.andrecastrosousa.character.Sim;
import academy.mindswap.andrecastrosousa.Game;
import academy.mindswap.andrecastrosousa.menu.enums.MenuType;
import academy.mindswap.andrecastrosousa.exceptions.HouseAlreadyCleanException;
import academy.mindswap.andrecastrosousa.exceptions.NoFundsEnoughtException;

import java.util.stream.IntStream;

public class CallHousekeeperCommand implements Command {
    private final int hour;

    public CallHousekeeperCommand(int hour) {
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
