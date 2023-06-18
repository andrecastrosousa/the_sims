package academy.mindswap.andrecastrosousa.action;

public class Action {

    private final ActionType type;
    private int stamina;

    public Action(ActionType type) {
        this.type = type;
        this.stamina = 100;
    }

    public ActionType getType() {
        return type;
    }

    public int getStamina() {
        return stamina;
    }

    public void decreaseStamina(int stamina) {
        if(this.stamina - stamina < 0) {
            this.stamina = 0;
            return;
        }
        this.stamina -= stamina;
    }

    public void increaseStamina(int stamina) {
        if(this.stamina + stamina > 100) {
            this.stamina = 100;
            return;
        }
        this.stamina += stamina;
    }
}
