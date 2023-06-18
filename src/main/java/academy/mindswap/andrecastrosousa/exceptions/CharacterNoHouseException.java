package academy.mindswap.andrecastrosousa.exceptions;

import academy.mindswap.andrecastrosousa.utils.Messages;

public class CharacterNoHouseException extends Exception {
    public CharacterNoHouseException() {
        super(Messages.CHARACTER_HAS_NO_HOUSE);
    }
}
