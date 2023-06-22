package academy.mindswap.andrecastrosousa.menu.commands;

import academy.mindswap.andrecastrosousa.exceptions.*;

/**
 * Design Pattern: COMMAND
 */
public class CommandInvoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void invoke() throws CharacterNoEnergyException, CharacterFullBladderException, CharacterNoHouseException, HouseTooDirtyException, NoFundsEnoughtException {
        command.execute();
    }
}
