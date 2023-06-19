package academy.mindswap.andrecastrosousa.state.dirty;

import academy.mindswap.andrecastrosousa.exceptions.HouseAlreadyCleanException;
import academy.mindswap.andrecastrosousa.exceptions.HouseTooDirtyException;

public interface Dirty {
    void mess() throws HouseTooDirtyException;

    void clean() throws HouseAlreadyCleanException;
}
