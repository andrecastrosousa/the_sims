package academy.mindswap.andrecastrosousa.command.action;

import academy.mindswap.andrecastrosousa.state.needs.NeedStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Design pattern: Abstract Factory
 */
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

    public ActionCommand getAction(List<NeedStatus> needs) {
        return switch (this) {
            case EAT -> new EatAction(needs);
            case SLEEP -> new SleepAction(needs);
            case PAINT -> new PaintAction(needs);
            case WORK -> new WorkAction(needs);
            case COOK -> new CookAction(needs);
            case PEE -> new PeeAction(needs);
            case WATCH_TV -> new PaintAction(needs);
        };
    }

    public static List<ActionType> getActionsWithoutDivisions() {
        return new ArrayList<>(List.of(WORK));
    }
}
