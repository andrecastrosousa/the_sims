package academy.mindswap.andrecastrosousa.server.gateway;

import academy.mindswap.andrecastrosousa.server.Database;
import academy.mindswap.andrecastrosousa.server.models.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SimMapper implements Mapper {

    private final Connection dbConnection;

    public SimMapper() {
        dbConnection = Database.getInstance().getConnection();
    }

    @Override
    public Entity findById(Long id) throws SQLException {
        Class<Sim> simClass = Sim.class;
        simClass.getFields();

        Statement statement = null;
        try {
            statement = dbConnection.createStatement();


        String query = "SELECT * FROM sim WHERE sim.id = " + id;

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String name = resultSet.getString("name");

            return new Sim(name, Gender.MALE, new Account(2L, 1000), new House(new ArrayList<>(), 299));
        }
        } catch (SQLException e) {
            dbConnection.rollback();
        }

        /*try {
            dbConnection.beginRequest();
            dbConnection.prepareStatement("SELECT * FROM user WHERE user.id = " + id);
            dbConnection.commit();
            dbConnection.
        } catch (SQLException e) {
            dbConnection.rollback();
        }*/
        return new Sim();
    }

    @Override
    public Entity find(String query) {
        return null;
    }

    @Override
    public Entity update(Long id, Entity entity) {
        return null;
    }

    @Override
    public Entity create(Entity entity) {
        return null;
    }

    @Override
    public Entity delete(Long id) {
        return null;
    }
}
