package academy.mindswap.andrecastrosousa.menu;

import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.menu.command.Command;

public interface Menu {

    Menu getEnumByOption(int option);

    Command execute(int option, Character character);
}
