package academy.mindswap.andrecastrosousa.character.needs;

public class BladderStatus extends NeedStatusImpl {
    public BladderStatus() {
        super(NeedsType.BLADDER);
    }

    @Override
    public String toString() {
        return "Bladder{" +
                "stamina=" + stamina +
                ", type=" + type +
                '}';
    }
}
