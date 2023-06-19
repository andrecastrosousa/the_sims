package academy.mindswap.andrecastrosousa.state.dirty;

import academy.mindswap.andrecastrosousa.domain.House;

public class ExtremelyDirty extends DirtyState {
    public ExtremelyDirty(House house) {
        super.house = house;
    }

    @Override
    public void clean() {
        house.setDirtyLevel(DirtyLevel.VERY_DIRTY);
    }
}
