package academy.mindswap.andrecastrosousa.strategy.needs;

import academy.mindswap.andrecastrosousa.command.action.ActionType;
import academy.mindswap.andrecastrosousa.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.template.NeedStatus;
import academy.mindswap.andrecastrosousa.template.NeedsType;

public abstract class NeedStaminaBase implements NeedStaminaStrategy {

    private final NeedsType type;

    public NeedStaminaBase(NeedsType type) {
        this.type = type;
    }

    @Override
    public NeedsType getType() {
        return type;
    }
}
