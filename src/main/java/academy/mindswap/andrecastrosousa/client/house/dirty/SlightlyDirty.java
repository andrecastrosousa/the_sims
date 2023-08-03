package academy.mindswap.andrecastrosousa.client.house.dirty;

import academy.mindswap.andrecastrosousa.server.models.House;

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
