package academy.mindswap.andrecastrosousa.menu.commands;

import academy.mindswap.andrecastrosousa.exceptions.*;

public interface Command {
    void execute() throws NoFundsEnoughtException, CharacterNoHouseException, HouseTooDirtyException, CharacterFullBladderException, CharacterNoEnergyException;
}
