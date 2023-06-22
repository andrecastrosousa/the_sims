package academy.mindswap.andrecastrosousa.house;

import academy.mindswap.andrecastrosousa.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoEnergyException;

public interface HouseComponent {
    void interact() throws CharacterNoEnergyException, CharacterFullBladderException;

    String getName();
}
