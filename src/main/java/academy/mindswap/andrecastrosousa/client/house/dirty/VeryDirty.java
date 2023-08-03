package academy.mindswap.andrecastrosousa.client.house.dirty;

import academy.mindswap.andrecastrosousa.server.models.House;

public class VeryDirty extends DirtyState {

    public VeryDirty(House house) {
        super.house = house;
    }

    @Override
    public void mess() {
        house.setDirtyLevel(DirtyLevel.EXTREMELY_DIRTY);
    }

    @Override
    public void clean() {
        house.setDirtyLevel(DirtyLevel.MODERATELY_DIRTY);
    }
}
