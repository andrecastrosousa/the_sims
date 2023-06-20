package academy.mindswap.andrecastrosousa.template.need;

public interface NeedStatus {

    void update(int stamina);

    NeedsType getType();

    int getStamina();
}
