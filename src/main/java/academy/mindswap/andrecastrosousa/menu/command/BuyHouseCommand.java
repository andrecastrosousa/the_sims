package academy.mindswap.andrecastrosousa.menu.command;

import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.exceptions.NoFundsEnoughtException;
import academy.mindswap.andrecastrosousa.house.House;

public class BuyHouseCommand implements Command {
    private Character character;
    private House house;


    public BuyHouseCommand(Character character, House house) {
        this.character = character;
        this.house = house;
    }

    @Override
    public void execute() throws NoFundsEnoughtException {
        if(character.getAccount().getBalance() < house.getCost()) {
            throw new NoFundsEnoughtException();
        }

    }
}
