package academy.mindswap.andrecastrosousa.strategy.needs;

import academy.mindswap.andrecastrosousa.domain.enums.ActionType;
import academy.mindswap.andrecastrosousa.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.template.need.NeedStatus;
import academy.mindswap.andrecastrosousa.template.need.NeedsType;

public interface NeedStaminaStrategy {

    void handle(NeedStatus needStatus, ActionType divisionType) throws CharacterNoEnergyException, CharacterFullBladderException;

    NeedsType getType();
}
