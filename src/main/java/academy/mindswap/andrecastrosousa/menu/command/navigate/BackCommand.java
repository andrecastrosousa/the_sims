package academy.mindswap.andrecastrosousa.menu.command.navigate;

import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.menu.command.Command;

public class BackCommand implements Command {
    @Override
    public void execute() throws NoFundsEnoughtException, CharacterNoHouseException, ExitApplication, HouseTooDirtyException, BackApplication {
        throw new BackApplication();
    }
}
