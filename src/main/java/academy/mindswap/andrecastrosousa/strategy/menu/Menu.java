package academy.mindswap.andrecastrosousa.strategy.menu;

import academy.mindswap.andrecastrosousa.domain.Character;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;

import java.io.IOException;

public interface Menu {

    boolean canHandle(MenuType menuFlow);

    void handle(Character character) throws IOException, ExitApplication, CharacterNoHouseException, NoFundsEnoughtException, HouseTooDirtyException, BackApplication, CharacterFullBladderException, CharacterNoEnergyException;
}
