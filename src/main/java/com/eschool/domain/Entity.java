package com.eschool.domain;

import java.util.UUID;

/**
 * Created by Click Chain on 8/24/2018.
 */
public class Entity {

    private UUID id;

    public Entity() {
        this.id = UUID.randomUUID();
    }

    public Entity(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
