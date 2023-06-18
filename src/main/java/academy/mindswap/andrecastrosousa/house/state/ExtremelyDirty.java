package academy.mindswap.andrecastrosousa.house.state;

import academy.mindswap.andrecastrosousa.house.House;

public class ExtremelyDirty extends DirtyState {
    public ExtremelyDirty(House house) {
        super.house = house;
    }

    @Override
    public void clean() {
        house.setDirtyLevel(DirtyLevel.VERY_DIRTY);
    }
}
