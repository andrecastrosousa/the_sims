package academy.mindswap.andrecastrosousa.client.exceptions;

import academy.mindswap.andrecastrosousa.utils.Messages;

public class CharacterFullBladderException extends Exception {
    public CharacterFullBladderException() {
        super(Messages.BLADDER_FULL);
    }

}
