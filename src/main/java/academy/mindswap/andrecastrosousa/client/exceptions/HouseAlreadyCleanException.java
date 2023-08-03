package academy.mindswap.andrecastrosousa.client.exceptions;

import academy.mindswap.andrecastrosousa.utils.Messages;

public class HouseAlreadyCleanException extends Exception {
    public HouseAlreadyCleanException() {
        super(Messages.HOUSE_ALREADY_CLEAN);
    }
}
