package academy.mindswap.andrecastrosousa.exceptions;

import academy.mindswap.andrecastrosousa.utils.Messages;

public class CharacterNoMoreHousesException extends Exception {
    public CharacterNoMoreHousesException() {
        super(Messages.CHARACTER_NO_MORE_HOUSE);
    }
}
