package academy.mindswap.andrecastrosousa.command.menu;

import academy.mindswap.andrecastrosousa.domain.Character;
import academy.mindswap.andrecastrosousa.exceptions.NoFundsEnoughtException;
import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.House;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;

public class BuyHouseCommand implements Command {
    private final Character character;
    private final House house;


    public BuyHouseCommand(Character character, House house) {
        this.character = character;
        this.house = house;
    }

    @Override
    public void execute() throws NoFundsEnoughtException {
        if(character.getBalance() < house.getCost()) {
            throw new NoFundsEnoughtException();
        }

        character.pay(house.getCost());
        character.setHouse(house);

        Game.setMenuType(MenuType.SIM_MENU);
    }
}
