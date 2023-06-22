package academy.mindswap.andrecastrosousa.command.action;

import academy.mindswap.andrecastrosousa.composite.Furniture;
import academy.mindswap.andrecastrosousa.domain.enums.ActionType;
import academy.mindswap.andrecastrosousa.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.exceptions.HouseTooDirtyException;

import java.io.Serializable;

public interface ActionCommand extends Serializable {
    void interact(Furniture furniture) throws CharacterFullBladderException, HouseTooDirtyException, CharacterNoEnergyException;

    ActionType getType();
}
