package academy.mindswap.andrecastrosousa.menu.commands;

import academy.mindswap.andrecastrosousa.character.Sim;
import academy.mindswap.andrecastrosousa.exceptions.NoFundsEnoughtException;
import academy.mindswap.andrecastrosousa.Game;
import academy.mindswap.andrecastrosousa.house.House;
import academy.mindswap.andrecastrosousa.menu.enums.MenuType;

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
