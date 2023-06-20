package academy.mindswap.andrecastrosousa.command.menu;

import academy.mindswap.andrecastrosousa.domain.Sim;
import academy.mindswap.andrecastrosousa.exceptions.NoFundsEnoughtException;
import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.House;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;

public class BuyHouseCommand implements Command {
    private final Sim sim;
    private final House house;


    public BuyHouseCommand(Sim sim, House house) {
        this.sim = sim;
        this.house = house;
    }

    @Override
    public void execute() throws NoFundsEnoughtException {
        if(sim.getBalance() < house.getCost()) {
            throw new NoFundsEnoughtException();
        }

        sim.pay(house.getCost());
        sim.setHouse(house);

        Game.setMenuType(MenuType.SIM_MENU);
    }
}
