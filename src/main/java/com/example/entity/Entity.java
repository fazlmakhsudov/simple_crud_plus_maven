package com.example.entity;

/**
 * Entity class, keeps entity objects
 */
public abstract class Entity {
    protected long mId;

    public Entity() {
    }

    public Entity(long id) {
        this.mId = id;
    }

    /**
     * forms description of entity
     *
     * @return description for menu
     */
    public abstract String showEntity();

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        this.mId = id;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + mId +
                '}';
    }
}
