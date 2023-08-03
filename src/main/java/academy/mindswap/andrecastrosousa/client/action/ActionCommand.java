package academy.mindswap.andrecastrosousa.client.action;

import academy.mindswap.andrecastrosousa.server.models.Furniture;
import academy.mindswap.andrecastrosousa.client.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.client.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.client.exceptions.HouseTooDirtyException;
import academy.mindswap.andrecastrosousa.client.menu.enums.ActionType;

import java.io.Serializable;

public interface ActionCommand extends Serializable {
    void interact(Furniture furniture) throws CharacterFullBladderException, HouseTooDirtyException, CharacterNoEnergyException;

    ActionType getType();
}
