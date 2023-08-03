package academy.mindswap.andrecastrosousa.client.character.needs;

import academy.mindswap.andrecastrosousa.client.character.needs.status.NeedStatus;
import academy.mindswap.andrecastrosousa.client.character.needs.status.NeedsType;
import academy.mindswap.andrecastrosousa.client.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.client.menu.enums.ActionType;

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
