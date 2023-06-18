package academy.mindswap.andrecastrosousa;

import academy.mindswap.andrecastrosousa.bank.Account;
import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.character.Gender;
import academy.mindswap.andrecastrosousa.game.Game;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.start();
    }
}