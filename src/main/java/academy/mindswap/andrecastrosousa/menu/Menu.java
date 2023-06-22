package academy.mindswap.andrecastrosousa.menu;

import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.menu.enums.MenuType;

import java.io.IOException;

public interface Menu {

    boolean canHandle(MenuType menuFlow);

    void handle() throws IOException, CharacterNoHouseException, NoFundsEnoughtException, HouseTooDirtyException, CharacterFullBladderException, CharacterNoEnergyException;

    void back();
}
