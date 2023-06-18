package academy.mindswap.andrecastrosousa.house.dirty;

import academy.mindswap.andrecastrosousa.house.House;

public class Clean extends DirtyState {

    public Clean(House house) {
        super.house = house;
    }

    @Override
    public void mess() {
        house.setDirtyLevel(DirtyLevel.SLIGHTLY_DIRTY);
    }
}
