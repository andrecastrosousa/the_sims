package academy.mindswap.andrecastrosousa.strategy.needs;

import academy.mindswap.andrecastrosousa.domain.enums.ActionType;
import academy.mindswap.andrecastrosousa.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.template.need.NeedStatus;
import academy.mindswap.andrecastrosousa.template.need.NeedsType;

import java.util.HashMap;
import java.util.List;

public class NeedStaminaChecker {

    private final List<NeedStatus> needs;

    private final HashMap<NeedsType, NeedStaminaStrategy> strategies;

    public NeedStaminaChecker(List<NeedStatus> needs) {
        this.needs = needs;
        strategies = setCheckers();
    }

    public void checkStamina(ActionType actionType) throws CharacterNoEnergyException, CharacterFullBladderException {
        for (NeedStatus needStatus: needs) {
            NeedStaminaStrategy strategy = strategies.get(needStatus.getType());

            if(strategy != null) {
                strategy.handle(needStatus, actionType);
            }
        }
    }

    private HashMap<NeedsType, NeedStaminaStrategy> setCheckers() {
        HashMap<NeedsType,NeedStaminaStrategy> strategies = new HashMap<>();

        NeedStaminaStrategy bladderStrategy = new BladderStamina();
        NeedStaminaStrategy energyStrategy = new EnergyStamina();

        strategies.put(bladderStrategy.getType(), bladderStrategy);
        strategies.put(energyStrategy.getType(), energyStrategy);

        return strategies;
    }
}
