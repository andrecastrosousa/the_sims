package academy.mindswap.andrecastrosousa.template;

public abstract class NeedStatusImpl implements NeedStatus {

    protected int stamina;
    protected final NeedsType type;

    public NeedStatusImpl(NeedsType type) {
        stamina = 100;
        this.type = type;
    }

    @Override
    public void update(int stamina) {
        if(this.stamina + stamina < 0) {
            this.stamina = 0;
            return;
        } else if(this.stamina + stamina > 100) {
            this.stamina = 100;
            return;
        }
        this.stamina += stamina;
    }

    @Override
    public NeedsType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "NeedStatusImpl{" +
                "stamina=" + stamina +
                ", type=" + type +
                '}';
    }
}
