package academy.mindswap.andrecastrosousa;

import academy.mindswap.andrecastrosousa.DB.Database;

public class Main {
    public static void main(String[] args) {
        // Game game = new Game();
        // game.start();
        Database.getInstance().connect();
    }
}