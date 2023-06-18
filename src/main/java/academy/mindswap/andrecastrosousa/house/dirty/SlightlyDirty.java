package academy.mindswap.andrecastrosousa.house.dirty;

import academy.mindswap.andrecastrosousa.house.House;

public class SlightlyDirty extends DirtyState {
    public SlightlyDirty(House house) {
        super.house = house;
    }

    @Override
    public void mess() {
        house.setDirtyLevel(DirtyLevel.MODERATELY_DIRTY);
    }

    @Override
    public void clean() {
        house.setDirtyLevel(DirtyLevel.CLEAN);
    }
}
