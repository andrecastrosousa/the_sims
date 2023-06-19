package academy.mindswap.andrecastrosousa.state.needs;

public class EnergyStatus extends NeedStatusImpl {
    public EnergyStatus() {
        super(NeedsType.ENERGY);
    }

    @Override
    public String toString() {
        return "Energy{" +
                "stamina=" + stamina +
                ", type=" + type +
                '}';
    }
}
