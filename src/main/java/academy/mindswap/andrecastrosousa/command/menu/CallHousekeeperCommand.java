package academy.mindswap.andrecastrosousa.command.menu;

import academy.mindswap.andrecastrosousa.domain.Character;
import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.House;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;
import academy.mindswap.andrecastrosousa.exceptions.*;

import java.util.stream.IntStream;

public class CallHousekeeperCommand implements Command {

    private final House house;
    private final int hour;
    private final Character character;

    public CallHousekeeperCommand(Character character, House house, int hour) {
        this.house = house;
        this.hour = hour;
        this.character = character;
    }

    @Override
    public void execute() throws NoFundsEnoughtException, CharacterNoHouseException, ExitApplication, HouseTooDirtyException, BackApplication {
        if(character.getBalance() - (10 * hour) < 0) {
            throw new NoFundsEnoughtException();
        }

        IntStream.range(0, hour).forEach(h -> {
            try {
                house.decreaseDirtyLevel();
            } catch (HouseAlreadyCleanException ignored) {
            }
        });

        character.pay(10 * hour);
        Game.setMenuType(MenuType.SIM_MENU);
    }
}
