package de.netseries.entities;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by talal on 16.07.16.
 */
@NodeEntity
public abstract class Entity {

    @GraphId
    private Long id;

    private String name;

    public Entity() {}

    public Entity(String name) {this.name = name;}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity)) return false;

        Entity entity = (Entity) o;

        return id.equals(entity.id);

    }

    @Override
    public int hashCode() {
        //Check the id
        int result = getId() != null ? getId().hashCode() : 0;
        return result;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
