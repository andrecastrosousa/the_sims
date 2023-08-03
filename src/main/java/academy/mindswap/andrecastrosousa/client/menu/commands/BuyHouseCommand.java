package academy.mindswap.andrecastrosousa.client.menu.commands;

import academy.mindswap.andrecastrosousa.server.models.Sim;
import academy.mindswap.andrecastrosousa.client.exceptions.NoFundsEnoughtException;
import academy.mindswap.andrecastrosousa.Game;
import academy.mindswap.andrecastrosousa.server.models.House;
import academy.mindswap.andrecastrosousa.client.menu.enums.MenuType;

public class BuyHouseCommand implements Command {
    private final House house;

    public BuyHouseCommand(House house) {
        this.house = house;
    }

    @Override
    public void execute() throws NoFundsEnoughtException {
        Sim sim = Game.getSim();

        if(sim.getBalance() < house.getCost()) {
            throw new NoFundsEnoughtException();
        }

        sim.pay(house.getCost());
        sim.setHouse(house);

        Game.setMenuType(MenuType.SIM_MENU);
    }
}
