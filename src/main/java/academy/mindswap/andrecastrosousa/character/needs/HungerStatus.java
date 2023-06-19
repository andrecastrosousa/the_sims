package academy.mindswap.andrecastrosousa.character.needs;

public class HungerStatus extends NeedStatusImpl {

    public HungerStatus() {
        super(NeedsType.HUNGER);
    }

    @Override
    public String toString() {
        return "Hunger{" +
                "stamina=" + stamina +
                ", type=" + type +
                '}';
    }
}
