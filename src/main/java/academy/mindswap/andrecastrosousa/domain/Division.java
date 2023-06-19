package academy.mindswap.andrecastrosousa.domain;

import academy.mindswap.andrecastrosousa.command.action.Action;
import academy.mindswap.andrecastrosousa.command.action.ActionCommand;

public class Division {
    private final String name;
    private final Action action;
    private final double exp;
    private final int staminaMultiplier;

    public Division(String name, Action action, double exp, int staminaMultiplier) {
        this.name = name;
        this.action = action;
        this.exp = exp;
        this.staminaMultiplier = staminaMultiplier;
    }

    public String getName() {
        return name;
    }

    public double getExp() {
        return exp;
    }

    public int getStaminaMultiplier() {
        return staminaMultiplier;
    }

    public ActionCommand getAction() {
        return action;
    }

    @Override
    public String toString() {
        return "Division{" +
                "name='" + name + '\'' +
                ", action=" + action +
                ", exp=" + exp +
                '}';
    }
}
