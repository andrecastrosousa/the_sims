package academy.mindswap.andrecastrosousa.client.character.needs;

import academy.mindswap.andrecastrosousa.client.character.needs.status.NeedStatus;
import academy.mindswap.andrecastrosousa.client.character.needs.status.NeedsType;
import academy.mindswap.andrecastrosousa.client.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.client.menu.enums.ActionType;

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
