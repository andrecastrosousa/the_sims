package academy.mindswap.andrecastrosousa.state.dirty;

import academy.mindswap.andrecastrosousa.domain.House;

public class Clean extends DirtyState {

    public Clean(House house) {
        super.house = house;
    }

    @Override
    public void mess() {
        house.setDirtyLevel(DirtyLevel.SLIGHTLY_DIRTY);
    }
}
