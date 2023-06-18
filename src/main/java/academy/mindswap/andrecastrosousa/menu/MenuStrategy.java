package academy.mindswap.andrecastrosousa.menu;

import academy.mindswap.andrecastrosousa.character.Character;

import java.io.IOException;

public interface MenuStrategy {

    boolean canHandle(TerminalInteraction menuFlow);

    int handle(Character character) throws IOException;
}
