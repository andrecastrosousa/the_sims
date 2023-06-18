package academy.mindswap.andrecastrosousa.action;

public class Skill {
    private final String name;

    private final ActionType actionType;

    private int level;

    public Skill(String name, ActionType actionType) {
        this.name = name;
        this.actionType = actionType;
        this.level = 1;
    }

    public String getName() {
        return name;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
