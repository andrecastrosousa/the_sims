package academy.mindswap.andrecastrosousa.command.menu;

import academy.mindswap.andrecastrosousa.exceptions.*;

/**
 * Design Pattern: COMMAND
 */
public class CommandInvoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void invoke() throws CharacterNoHouseException, NoFundsEnoughtException, HouseTooDirtyException, CharacterFullBladderException, CharacterNoEnergyException {
        command.execute();
    }
}
