package academy.mindswap.andrecastrosousa.character.needs;

import academy.mindswap.andrecastrosousa.menu.enums.ActionType;
import academy.mindswap.andrecastrosousa.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.character.needs.status.NeedStatus;
import academy.mindswap.andrecastrosousa.character.needs.status.NeedsType;

public interface NeedStaminaStrategy {

    void handle(NeedStatus needStatus, ActionType divisionType) throws CharacterNoEnergyException, CharacterFullBladderException;

    NeedsType getType();
}
