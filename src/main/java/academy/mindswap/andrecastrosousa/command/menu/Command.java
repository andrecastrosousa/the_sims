package academy.mindswap.andrecastrosousa.command.menu;

import academy.mindswap.andrecastrosousa.exceptions.*;

public interface Command {
    void execute() throws NoFundsEnoughtException, CharacterNoHouseException, ExitApplication, HouseTooDirtyException, BackApplication, CharacterFullBladderException, CharacterNoEnergyException;
}
