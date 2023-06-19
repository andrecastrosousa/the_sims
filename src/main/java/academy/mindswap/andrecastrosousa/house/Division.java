package academy.mindswap.andrecastrosousa.house;

import academy.mindswap.andrecastrosousa.action.command.ActionType;

public class Division {
    private final String name;
    private final ActionType type;
    private final double exp;
    private final int staminaCost;

    public Division(String name, ActionType type, double exp, int staminaCost) {
        this.name = name;
        this.type = type;
        this.exp = exp;
        this.staminaCost = staminaCost;
    }

    public String getName() {
        return name;
    }

    public ActionType getType() {
        return type;
    }

    public double getExp() {
        return exp;
    }

    public int getStaminaCost() {
        return staminaCost;
    }

    @Override
    public String toString() {
        return "Division{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", exp=" + exp +
                '}';
    }
}
