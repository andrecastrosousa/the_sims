package academy.mindswap.andrecastrosousa.exceptions;

import academy.mindswap.andrecastrosousa.Messages;

public class HouseTooDirtyException extends Exception {
    public HouseTooDirtyException() {
        super(Messages.HOUSE_TOO_DIRTY);
    }
}
