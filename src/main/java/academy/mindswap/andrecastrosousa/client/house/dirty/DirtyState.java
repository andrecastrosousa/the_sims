package academy.mindswap.andrecastrosousa.client.house.dirty;

import academy.mindswap.andrecastrosousa.client.exceptions.HouseAlreadyCleanException;
import academy.mindswap.andrecastrosousa.client.exceptions.HouseTooDirtyException;
import academy.mindswap.andrecastrosousa.server.models.House;

/**
 * Design Pattern: STATE
 */
public abstract class DirtyState implements Dirty {

    protected House house;

    public static Dirty buildState(House house) {
        return switch (house.getDirtyLevel()) {
            case CLEAN -> new Clean(house);
            case SLIGHTLY_DIRTY -> new SlightlyDirty(house);
            case MODERATELY_DIRTY -> new ModeratelyDirty(house);
            case VERY_DIRTY -> new VeryDirty(house);
            case EXTREMELY_DIRTY -> new ExtremelyDirty(house);
        };
    }

    @Override
    public void mess() throws HouseTooDirtyException {
        throw new HouseTooDirtyException();
    }

    @Override
    public void clean() throws HouseAlreadyCleanException {
        throw new HouseAlreadyCleanException();
    }
}
