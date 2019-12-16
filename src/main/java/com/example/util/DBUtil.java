package com.example.util;

import com.example.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtil {

    private final Map<Long, Product> mysqlStorage;
    private long index;

    {
        mysqlStorage = new HashMap<>();
        index = 0;
    }

    public long add(final Product item) {
        index++;
        item.setId(index);
        mysqlStorage.put(index, item);
        return index;
    }

    public Product get(final long id) {
        return mysqlStorage.getOrDefault(id, null);
    }

    public boolean save(final Product item) {
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

    public List<Product> getAll() {
        return new ArrayList<>(mysqlStorage.values());
    }

}
