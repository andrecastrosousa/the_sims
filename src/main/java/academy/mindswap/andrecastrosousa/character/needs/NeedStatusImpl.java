package academy.mindswap.andrecastrosousa.character.needs;

public class NeedStatusImpl implements NeedStatus {

    private int stamina;

    public NeedStatusImpl() {
        stamina = 100;
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
