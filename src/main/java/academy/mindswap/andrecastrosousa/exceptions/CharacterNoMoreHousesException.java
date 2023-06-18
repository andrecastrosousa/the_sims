package academy.mindswap.andrecastrosousa.exceptions;

import academy.mindswap.andrecastrosousa.Messages;

public class CharacterNoMoreHousesException extends Exception {
    public CharacterNoMoreHousesException() {
        super(Messages.CHARACTER_NO_MORE_HOUSE);
    }
}
