package academy.mindswap.andrecastrosousa.client.exceptions;

import academy.mindswap.andrecastrosousa.utils.Messages;

public class CharacterNoMoreHousesException extends Exception {
    public CharacterNoMoreHousesException() {
        super(Messages.CHARACTER_NO_MORE_HOUSE);
    }
}
