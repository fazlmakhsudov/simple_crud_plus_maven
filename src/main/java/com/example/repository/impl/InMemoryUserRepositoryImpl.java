package com.example.repository.impl;

import com.example.entity.User;
import com.example.repository.GenericRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Implementation of GenericRepository concerning internal memory
 */
public class InMemoryUserRepositoryImpl implements GenericRepository<User> {


    private final Map<Long, User> memory;
    private long index;


    public InMemoryUserRepositoryImpl(final Map<Long, User> memory, final long startIndex) {
        this.memory = memory;
        this.index = startIndex;
    }

    @Override
    public long create(final User item) {
        item.setId(index);
        memory.put(index, item);
        return index++;
    }

    @Override
    public User read(final long id) {
        return memory.getOrDefault(id, null);
    }

    @Override
    public boolean update(final User item) {
        if (!memory.containsKey(item.getId())) {
            return false;
        }
        memory.put(item.getId(), item);
        return true;
    }

    @Override
    public boolean delete(final long id) {
        if (!memory.containsKey(id)) {
            return false;
        }
        memory.remove(id);
        return true;
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(memory.values());
    }
}
