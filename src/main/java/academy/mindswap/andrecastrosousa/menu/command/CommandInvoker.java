package academy.mindswap.andrecastrosousa.menu.command;

import academy.mindswap.andrecastrosousa.exceptions.CharacterNoHouseException;
import academy.mindswap.andrecastrosousa.exceptions.ExitApplication;
import academy.mindswap.andrecastrosousa.exceptions.HouseTooDirtyException;
import academy.mindswap.andrecastrosousa.exceptions.NoFundsEnoughtException;

/**
 * Design Pattern: COMMAND
 */
public class CommandInvoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void invoke() throws ExitApplication, CharacterNoHouseException, NoFundsEnoughtException, HouseTooDirtyException {
        command.execute();
    }
}
