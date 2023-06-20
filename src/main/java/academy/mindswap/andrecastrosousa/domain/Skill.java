package academy.mindswap.andrecastrosousa.domain;

import academy.mindswap.andrecastrosousa.command.action.ActionType;

import java.io.Serializable;

public class Skill implements Serializable {
    private final String name;


    private int level;

    public Skill(String name, ActionType actionType) {
        this.name = name;
        this.level = 1;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
