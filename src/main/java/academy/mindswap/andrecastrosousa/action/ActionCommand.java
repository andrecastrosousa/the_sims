package academy.mindswap.andrecastrosousa.action;

import academy.mindswap.andrecastrosousa.house.Furniture;
import academy.mindswap.andrecastrosousa.menu.enums.ActionType;
import academy.mindswap.andrecastrosousa.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.exceptions.HouseTooDirtyException;

import java.io.Serializable;

public interface ActionCommand extends Serializable {
    void interact(Furniture furniture) throws CharacterFullBladderException, HouseTooDirtyException, CharacterNoEnergyException;

    ActionType getType();
}
