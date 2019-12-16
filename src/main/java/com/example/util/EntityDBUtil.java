package com.example.util;

import com.example.entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DAO class
 * @param <T> extends Entity
 */
public class EntityDBUtil<T extends Entity> {

    private final Map<Long, T> mysqlStorage;
    private long index;

    {
        mysqlStorage = new HashMap<>();
        index = 0;
    }

    public long add(final T item) {
        index++;
        item.setId(index);
        mysqlStorage.put(index, item);
        return index;
    }

    public T get(final long id) {
        return mysqlStorage.getOrDefault(id, null);
    }

    public boolean save(final T item) {
        if (!mysqlStorage.containsKey(item.getId())) {
            return false;
        }
        mysqlStorage.put(item.getId(), item);
        return true;
    }

    public boolean remove(final long id) {
        if (!mysqlStorage.containsKey(id)) {
            return false;
        }
        mysqlStorage.remove(id);
        return true;
    }

    public List<T> getAll() {
        return new ArrayList<>(mysqlStorage.values());
    }

}
