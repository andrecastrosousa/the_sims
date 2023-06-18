package academy.mindswap.andrecastrosousa.exceptions;

import academy.mindswap.andrecastrosousa.utils.Messages;

public class CharacterHungryException extends Exception {
    public CharacterHungryException() {
        super(Messages.CHARACTER_HUNGRY);
    }
}
