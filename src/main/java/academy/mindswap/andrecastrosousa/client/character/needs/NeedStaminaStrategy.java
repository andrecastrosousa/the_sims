package academy.mindswap.andrecastrosousa.client.character.needs;

import academy.mindswap.andrecastrosousa.client.character.needs.status.NeedStatus;
import academy.mindswap.andrecastrosousa.client.character.needs.status.NeedsType;
import academy.mindswap.andrecastrosousa.client.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.client.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.client.menu.enums.ActionType;

public interface NeedStaminaStrategy {

    void handle(NeedStatus needStatus, ActionType divisionType) throws CharacterNoEnergyException, CharacterFullBladderException;

    NeedsType getType();
}
