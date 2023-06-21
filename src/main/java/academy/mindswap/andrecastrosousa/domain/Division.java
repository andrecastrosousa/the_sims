package academy.mindswap.andrecastrosousa.domain;

import academy.mindswap.andrecastrosousa.command.action.Action;
import academy.mindswap.andrecastrosousa.command.action.ActionCommand;
import academy.mindswap.andrecastrosousa.command.action.ActionType;
import academy.mindswap.andrecastrosousa.template.need.NeedStatus;
import academy.mindswap.andrecastrosousa.template.skill.SkillType;

import java.io.Serializable;

public class Division implements Serializable {
    private final String name;
    private final ActionCommand action;
    private final double exp;

    public Division(String name, Action action, double exp) {
        this.name = name;
        this.action = action;
        this.exp = exp;
    }

    public String getName() {
        return name;
    }

    public ActionCommand getAction() {
        return action;
    }

    public ActionType getActionType() {
        return action.getType();
    }

    public SkillType getSkillType() {
        return ((Action) action).getSkillType();
    }

    public int getStaminaCost(NeedStatus need) {
        return ((Action) action).getStaminaCost(need);
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
