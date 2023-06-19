package academy.mindswap.andrecastrosousa.menu.command;

import academy.mindswap.andrecastrosousa.exceptions.*;

/**
 * Design Pattern: COMMAND
 */
public class CommandInvoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void invoke() throws ExitApplication, CharacterNoHouseException, NoFundsEnoughtException, HouseTooDirtyException, BackApplication {
        command.execute();
    }
}
