package academy.mindswap.andrecastrosousa.command.menu.navigate;

import academy.mindswap.andrecastrosousa.command.menu.Command;
import academy.mindswap.andrecastrosousa.exceptions.*;

public class BackCommand implements Command {
    @Override
    public void execute() throws NoFundsEnoughtException, CharacterNoHouseException, ExitApplication, HouseTooDirtyException, BackApplication {
        throw new BackApplication();
    }
}
