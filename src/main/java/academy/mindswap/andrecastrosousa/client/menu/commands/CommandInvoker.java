package academy.mindswap.andrecastrosousa.client.menu.commands;

import academy.mindswap.andrecastrosousa.client.exceptions.*;

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
