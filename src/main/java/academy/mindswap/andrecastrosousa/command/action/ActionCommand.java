package academy.mindswap.andrecastrosousa.command.action;

import academy.mindswap.andrecastrosousa.domain.Character;
import academy.mindswap.andrecastrosousa.domain.Division;
import academy.mindswap.andrecastrosousa.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.exceptions.HouseTooDirtyException;

public interface ActionCommand {
    void perform(Division division) throws CharacterFullBladderException, HouseTooDirtyException, CharacterNoEnergyException;

    ActionType getType();

    void setCharacter(Character character);
}
