package academy.mindswap.andrecastrosousa.game;

import academy.mindswap.andrecastrosousa.bank.Account;
import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.character.Gender;

public class Game {

    public void start() {
        Character character = new Character();

        character.setName("André");
        character.setGender(Gender.MALE);
        character.setAccount(new Account(1, 1000));

        while(true) {

        }
    }
}
