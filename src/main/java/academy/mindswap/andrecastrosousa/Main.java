package academy.mindswap.andrecastrosousa;

import academy.mindswap.andrecastrosousa.server.Database;

public class Main {
    public static void main(String[] args) {
        // Game game = new Game();
        // game.start();
        Database db =  Database.getInstance();
        db.connect();

    }
}