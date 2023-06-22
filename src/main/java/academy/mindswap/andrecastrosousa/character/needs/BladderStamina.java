package academy.mindswap.andrecastrosousa.character.needs;

import academy.mindswap.andrecastrosousa.menu.enums.ActionType;
import academy.mindswap.andrecastrosousa.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.character.needs.status.NeedStatus;
import academy.mindswap.andrecastrosousa.character.needs.status.NeedsType;

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
