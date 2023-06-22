package academy.mindswap.andrecastrosousa.character.needs.status;

import java.io.Serializable;

public interface NeedStatus extends Serializable {

    void update(int stamina);

    NeedsType getType();

    int getStamina();
}
