package academy.mindswap.andrecastrosousa.exceptions;

import academy.mindswap.andrecastrosousa.utils.Messages;

public class CharacterNoEnergyException extends Exception {
    public CharacterNoEnergyException() {
        super(Messages.CHARACTER_NO_ENERGY);
    }
}
