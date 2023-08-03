package academy.mindswap.andrecastrosousa.client.exceptions;

import academy.mindswap.andrecastrosousa.utils.Messages;

public class HouseTooDirtyException extends Exception {
    public HouseTooDirtyException() {
        super(Messages.HOUSE_TOO_DIRTY);
    }
}
