package academy.mindswap.andrecastrosousa.state.dirty;

import academy.mindswap.andrecastrosousa.domain.House;

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