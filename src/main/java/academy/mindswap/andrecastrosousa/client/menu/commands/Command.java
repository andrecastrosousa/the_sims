package academy.mindswap.andrecastrosousa.client.menu.commands;

import academy.mindswap.andrecastrosousa.client.exceptions.*;

public interface Command {
    void execute() throws NoFundsEnoughtException, CharacterNoHouseException, HouseTooDirtyException, CharacterFullBladderException, CharacterNoEnergyException;
}
