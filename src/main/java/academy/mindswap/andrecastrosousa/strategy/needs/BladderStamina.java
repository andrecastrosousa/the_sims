package academy.mindswap.andrecastrosousa.strategy.needs;

import academy.mindswap.andrecastrosousa.command.action.ActionType;
import academy.mindswap.andrecastrosousa.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.template.NeedStatus;
import academy.mindswap.andrecastrosousa.template.NeedsType;

public class BladderStamina extends NeedStaminaBase {

    public BladderStamina() {
        super(NeedsType.BLADDER);
    }

    @Override
    public void handle(NeedStatus needStatus, ActionType divisionType) throws CharacterFullBladderException {
        if(needStatus.getStamina() == 0 && divisionType != ActionType.PEE) {
            throw new CharacterFullBladderException();
        }
    }
}
