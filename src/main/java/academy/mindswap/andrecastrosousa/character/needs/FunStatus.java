package academy.mindswap.andrecastrosousa.character.needs;

public class FunStatus extends NeedStatusImpl {
    public FunStatus() {
        super(NeedsType.FUN);
    }

    @Override
    public String toString() {
        return "Fun{" +
                "stamina=" + stamina +
                ", type=" + type +
                '}';
    }
}
