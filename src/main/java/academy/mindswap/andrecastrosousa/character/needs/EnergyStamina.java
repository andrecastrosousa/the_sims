package academy.mindswap.andrecastrosousa.character.needs;

import academy.mindswap.andrecastrosousa.menu.enums.ActionType;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.character.needs.status.NeedStatus;
import academy.mindswap.andrecastrosousa.character.needs.status.NeedsType;

public class EnergyStamina extends NeedStaminaBase {

    public EnergyStamina() {
        super(NeedsType.ENERGY);
    }

    @Override
    public void handle(NeedStatus needStatus, ActionType divisionType) throws CharacterNoEnergyException {
        if(needStatus.getStamina() == 0 && divisionType != ActionType.SLEEP) {
            throw new CharacterNoEnergyException();
        }
    }
}
