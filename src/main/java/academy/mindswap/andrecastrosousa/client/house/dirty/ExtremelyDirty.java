package academy.mindswap.andrecastrosousa.client.house.dirty;

import academy.mindswap.andrecastrosousa.server.models.House;

public class ExtremelyDirty extends DirtyState {
    public ExtremelyDirty(House house) {
        super.house = house;
    }

    @Override
    public void clean() {
        house.setDirtyLevel(DirtyLevel.VERY_DIRTY);
    }
}
