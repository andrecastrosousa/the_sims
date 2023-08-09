package academy.mindswap.andrecastrosousa.server.gateway;

import academy.mindswap.andrecastrosousa.server.models.Entity;

import java.sql.SQLException;

public interface Mapper {
    Entity findById(Long id) throws SQLException;

    Entity find(String query);

    Entity update(Long id, Entity entity);

    Entity create(Entity entity);

    Entity delete(Long id);

}
