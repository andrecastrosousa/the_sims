package academy.mindswap.andrecastrosousa.domain;

import academy.mindswap.andrecastrosousa.command.action.Action;
import academy.mindswap.andrecastrosousa.command.action.ActionCommand;

import java.io.Serializable;

public class Division implements Serializable {
    private final String name;
    private final Action action;
    private final double exp;

    public Division(String name, Action action, double exp) {
        this.name = name;
        this.action = action;
        this.exp = exp;
    }

    public String getName() {
        return name;
    }

    public double getExp() {
        return exp;
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
