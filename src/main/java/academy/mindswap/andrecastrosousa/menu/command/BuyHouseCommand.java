package academy.mindswap.andrecastrosousa.menu.command;

import academy.mindswap.andrecastrosousa.action.Action;
import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.exceptions.NoFundsEnoughtException;
import academy.mindswap.andrecastrosousa.game.Game;
import academy.mindswap.andrecastrosousa.house.House;
import academy.mindswap.andrecastrosousa.menu.TerminalInteraction;

import java.util.List;

public class BuyHouseCommand implements Command {
    private Character character;
    private House house;


    public BuyHouseCommand(Character character, House house) {
        this.character = character;
        this.house = house;
    }

    @Override
    public void execute() throws NoFundsEnoughtException {
        if(character.getBalance() < house.getCost()) {
            throw new NoFundsEnoughtException();
        }
        character.setHouse(house);

        List<Action> actions = house.getDivisions().stream()
                .map(d -> new Action(d.getType()))
                .distinct()
                .toList();
        character.setActions(actions);

        Game.setTerminalInteraction(TerminalInteraction.ACTIONS_MENU);
    }
}
