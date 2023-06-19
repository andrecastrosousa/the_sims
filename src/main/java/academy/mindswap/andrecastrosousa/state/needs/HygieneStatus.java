package academy.mindswap.andrecastrosousa.state.needs;

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
