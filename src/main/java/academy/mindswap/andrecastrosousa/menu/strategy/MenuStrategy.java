package academy.mindswap.andrecastrosousa.menu.strategy;

import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoHouseException;
import academy.mindswap.andrecastrosousa.exceptions.ExitApplication;
import academy.mindswap.andrecastrosousa.exceptions.NoFundsEnoughtException;
import academy.mindswap.andrecastrosousa.menu.TerminalInteraction;

import java.io.IOException;

public interface MenuStrategy {

    boolean canHandle(TerminalInteraction menuFlow);

    void handle(Character character) throws IOException, ExitApplication, CharacterNoHouseException, NoFundsEnoughtException;
}
