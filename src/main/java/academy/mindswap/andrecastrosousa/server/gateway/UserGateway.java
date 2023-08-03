package academy.mindswap.andrecastrosousa.server.gateway;

import academy.mindswap.andrecastrosousa.server.Database;
import academy.mindswap.andrecastrosousa.server.models.Entity;
import academy.mindswap.andrecastrosousa.server.models.Sim;

import java.sql.Connection;
import java.sql.SQLException;

public class UserGateway implements Gateway {

    private final Connection dbConnection;

    public UserGateway() {
        dbConnection = Database.getInstance().getConnection();
    }

    @Override
    public Entity findById(Long id) {
        Class<Sim> simClass = Sim.class;
        simClass.getFields();

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
