package academy.mindswap.andrecastrosousa.server.gateway;

import academy.mindswap.andrecastrosousa.server.models.Entity;

public interface Gateway {
    Entity findById(Long id);

    Entity find(String query);

    Entity update(Long id, Entity entity);

    Entity create(Entity entity);

    Entity delete(Long id);

}
