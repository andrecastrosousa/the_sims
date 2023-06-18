package academy.mindswap.andrecastrosousa.menu.command;

import academy.mindswap.andrecastrosousa.exceptions.CharacterNoHouseException;
import academy.mindswap.andrecastrosousa.exceptions.NoFundsEnoughtException;

public interface Command {
    void execute() throws NoFundsEnoughtException, CharacterNoHouseException;
}