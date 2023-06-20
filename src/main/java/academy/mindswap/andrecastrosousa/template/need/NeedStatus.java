package academy.mindswap.andrecastrosousa.template.need;

import java.io.Serializable;

public interface NeedStatus extends Serializable {

    void update(int stamina);

    NeedsType getType();

    int getStamina();
}
