package academy.mindswap.andrecastrosousa.client.house;

import academy.mindswap.andrecastrosousa.client.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.client.exceptions.CharacterNoEnergyException;

public interface HouseComponent {
    void interact() throws CharacterNoEnergyException, CharacterFullBladderException;

    String getName();
}
