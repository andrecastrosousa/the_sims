package academy.mindswap.andrecastrosousa.client.exceptions;

import academy.mindswap.andrecastrosousa.utils.Messages;

public class NoFundsEnoughtException extends Exception {
    public NoFundsEnoughtException() {
        super(Messages.NO_FUNDS_ENOUGH);
    }
}
