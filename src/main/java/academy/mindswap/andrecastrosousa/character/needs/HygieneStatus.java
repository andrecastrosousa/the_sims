package academy.mindswap.andrecastrosousa.character.needs;

public class HygieneStatus extends NeedStatusImpl {

    public HygieneStatus() {
        super(NeedsType.HYGIENE);
    }

    @Override
    public String toString() {
        return "Hygiene{" +
                "stamina=" + stamina +
                ", type=" + type +
                '}';
    }
}
