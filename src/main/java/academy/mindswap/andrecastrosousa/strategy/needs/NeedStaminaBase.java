package academy.mindswap.andrecastrosousa.strategy.needs;

import academy.mindswap.andrecastrosousa.template.need.NeedsType;

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
