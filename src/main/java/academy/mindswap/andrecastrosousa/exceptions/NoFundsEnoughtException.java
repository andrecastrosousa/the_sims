package academy.mindswap.andrecastrosousa.exceptions;

import academy.mindswap.andrecastrosousa.Messages;

public class NoFundsEnoughtException extends Exception {
    public NoFundsEnoughtException() {
        super(Messages.NO_FUNDS_ENOUGH);
    }
}
