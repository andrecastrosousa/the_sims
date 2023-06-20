package academy.mindswap.andrecastrosousa.strategy.needs;

import academy.mindswap.andrecastrosousa.command.action.ActionType;
import academy.mindswap.andrecastrosousa.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.template.NeedStatus;
import academy.mindswap.andrecastrosousa.template.NeedsType;

public interface NeedStaminaStrategy {

    void handle(NeedStatus needStatus, ActionType divisionType) throws CharacterNoEnergyException, CharacterFullBladderException;

    NeedsType getType();
}
