package academy.mindswap.andrecastrosousa.exceptions;

import academy.mindswap.andrecastrosousa.utils.Messages;

public class CharacterNoActionException extends Exception {
    public CharacterNoActionException() {
        super(Messages.CHARACTER_NO_ACTION);
    }
}
