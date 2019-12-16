package com.example.repository.impl;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import com.example.util.DBUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InMemoryProductRepositoryImpl implements ProductRepository {


    private final Map<Long, Product> memory;
    private long index;


    public InMemoryProductRepositoryImpl(final Map<Long, Product> memory, final long startIndex) {
        this.memory = memory;
        this.index = startIndex;
    }

    @Override
    public long create(final Product item) {
        item.setId(index);
        memory.put(index, item);
        return index++;
    }

    @Override
    public Product read(final long id) {
        return memory.getOrDefault(id, null);
    }

    @Override
    public boolean update(final Product item) {
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
    public List<Product> getAll() {
        return new ArrayList<>(memory.values());
    }
}
