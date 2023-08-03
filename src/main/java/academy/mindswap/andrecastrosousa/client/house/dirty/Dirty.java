package academy.mindswap.andrecastrosousa.client.house.dirty;

import academy.mindswap.andrecastrosousa.client.exceptions.HouseAlreadyCleanException;
import academy.mindswap.andrecastrosousa.client.exceptions.HouseTooDirtyException;

public interface Dirty {
    void mess() throws HouseTooDirtyException;

    void clean() throws HouseAlreadyCleanException;
}
