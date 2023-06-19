package academy.mindswap.andrecastrosousa.action;

import academy.mindswap.andrecastrosousa.action.command.ActionType;

public class Skill {
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
