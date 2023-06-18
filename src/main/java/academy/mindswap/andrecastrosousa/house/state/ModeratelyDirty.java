package academy.mindswap.andrecastrosousa.house.state;

import academy.mindswap.andrecastrosousa.exceptions.HouseAlreadyCleanException;
import academy.mindswap.andrecastrosousa.house.House;

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
