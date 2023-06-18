package academy.mindswap.andrecastrosousa.house.state;

import academy.mindswap.andrecastrosousa.exceptions.HouseAlreadyCleanException;
import academy.mindswap.andrecastrosousa.exceptions.HouseTooDirtyException;

public interface Dirty {
    void mess() throws HouseTooDirtyException;

    void clean() throws HouseAlreadyCleanException;
}
