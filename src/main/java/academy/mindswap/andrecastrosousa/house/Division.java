package academy.mindswap.andrecastrosousa.house;

import academy.mindswap.andrecastrosousa.action.ActionType;

public class Division {
    private final String name;
    private final ActionType type;
    private final double exp;

    public Division(String name, ActionType type, double exp) {
        this.name = name;
        this.type = type;
        this.exp = exp;
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

    @Override
    public String toString() {
        return "Division{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", exp=" + exp +
                '}';
    }
}
