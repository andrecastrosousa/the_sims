package academy.mindswap.andrecastrosousa.command.action;

import academy.mindswap.andrecastrosousa.domain.Character;
import academy.mindswap.andrecastrosousa.domain.Division;

public interface ActionCommand {
    void perform(Division division);

    ActionType getType();

    void setCharacter(Character character);
}
