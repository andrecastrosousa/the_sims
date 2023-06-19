package academy.mindswap.andrecastrosousa.state.needs;

public interface NeedStatus {

    void update(int stamina);

    NeedsType getType();
}
