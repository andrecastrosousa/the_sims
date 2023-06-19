package academy.mindswap.andrecastrosousa.action.strategy;

import academy.mindswap.andrecastrosousa.character.needs.NeedStatus;
import academy.mindswap.andrecastrosousa.character.needs.NeedsType;

public enum ActionType {
    EAT(-10, -5, 0, 100, -10),
    SLEEP(-20, 100, 0, -25, -20),
    COOK(-5, -20, 5, -20, -20),
    WORK(-10, -70, 10, -40, -30),
    WATCH_TV(-5, -25, 25, -20, -15),
    PEE(100, -2, 0, -2, -5),
    PAINT(-10, -25, 30, -10, -15);

    private final int bladderStamina;
    private final int energyStamina;
    private final int funStamina;
    private final int hungerStamina;
    private final int hygieneStamina;

    ActionType(int bladderStamina, int energyStamina, int funStamina, int hungerStamina, int hygieneStamina) {
        this.bladderStamina =bladderStamina;
        this.energyStamina = energyStamina;
        this.funStamina = funStamina;
        this.hungerStamina = hungerStamina;
        this.hygieneStamina = hygieneStamina;
    }

    public int getStaminaCost(NeedStatus needStatus) {
        return switch (needStatus.getType()) {
            case BLADDER -> bladderStamina;
            case FUN -> funStamina;
            case ENERGY -> energyStamina;
            case HUNGER -> hungerStamina;
            case HYGIENE -> hygieneStamina;
        };
    }
}
