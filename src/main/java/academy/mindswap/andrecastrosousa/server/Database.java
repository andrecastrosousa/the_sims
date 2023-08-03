package academy.mindswap.andrecastrosousa.server;

import java.sql.*;

public class Database {

    private static Database instance;

    public static synchronized Database getInstance() {
        if(instance == null) {
            instance = new Database();
        }
        return instance;
    }

    private Connection connection;

    public void connect() {
        String dbURL = "jdbc:mysql://localhost:3306/mindswap_db";
        String username = "root";
        String password = "123";

        try {
            connection = DriverManager.getConnection(dbURL, username, password);
        } catch (SQLException ex) {
            System.out.println("Connection failed: " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    private Database() {};
}
