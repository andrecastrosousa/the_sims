package academy.mindswap.andrecastrosousa;

import academy.mindswap.andrecastrosousa.DB.Database;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Game game = new Game();
        // game.start();
        Database db =  Database.getInstance();
        db.connect();

    }
}