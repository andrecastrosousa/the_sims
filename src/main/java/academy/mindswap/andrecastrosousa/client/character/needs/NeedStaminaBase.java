package academy.mindswap.andrecastrosousa.client.character.needs;

import academy.mindswap.andrecastrosousa.client.character.needs.status.NeedsType;

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
