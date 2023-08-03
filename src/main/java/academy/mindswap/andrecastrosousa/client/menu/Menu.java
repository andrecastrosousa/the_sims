package academy.mindswap.andrecastrosousa.client.menu;

import academy.mindswap.andrecastrosousa.client.exceptions.*;
import academy.mindswap.andrecastrosousa.client.menu.enums.MenuType;

import java.io.IOException;

public interface Menu {

    boolean canHandle(MenuType menuFlow);

    void handle() throws IOException, CharacterNoHouseException, NoFundsEnoughtException, HouseTooDirtyException, CharacterFullBladderException, CharacterNoEnergyException;

    void back();
}
