package academy.mindswap.andrecastrosousa.strategy.needs;

import academy.mindswap.andrecastrosousa.domain.enums.ActionType;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.template.need.NeedStatus;
import academy.mindswap.andrecastrosousa.template.need.NeedsType;

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
