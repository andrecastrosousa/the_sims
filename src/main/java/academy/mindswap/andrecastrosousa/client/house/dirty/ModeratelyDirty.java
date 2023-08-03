package academy.mindswap.andrecastrosousa.client.house.dirty;

import academy.mindswap.andrecastrosousa.client.exceptions.HouseAlreadyCleanException;
import academy.mindswap.andrecastrosousa.server.models.House;

public class ModeratelyDirty extends DirtyState {

    public ModeratelyDirty(House house) {
        super.house = house;
    }

    @Override
    public void mess() {
        house.setDirtyLevel(DirtyLevel.VERY_DIRTY);
    }

    @Override
    public void clean() throws HouseAlreadyCleanException {
        house.setDirtyLevel(DirtyLevel.SLIGHTLY_DIRTY);
    }
}
