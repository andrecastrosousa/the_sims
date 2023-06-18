package academy.mindswap.andrecastrosousa.house;

import academy.mindswap.andrecastrosousa.action.ActionType;

public class Division {
    private final String name;
    private final ActionType actionType;
    private final double exp;
    private final DivisionType type;

    public Division(String name, ActionType actionType, double exp, DivisionType type) {
        this.name = name;
        this.actionType = actionType;
        this.exp = exp;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public double getExp() {
        return exp;
    }

    public DivisionType getType() {
        return type;
    }
}
