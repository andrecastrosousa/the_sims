package academy.mindswap.andrecastrosousa.menu.command;

import academy.mindswap.andrecastrosousa.exceptions.*;

public class BackCommand implements Command {
    @Override
    public void execute() throws NoFundsEnoughtException, CharacterNoHouseException, ExitApplication, HouseTooDirtyException, BackApplication {
        throw new BackApplication();
    }
}
