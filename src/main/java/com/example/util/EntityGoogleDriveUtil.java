package com.example.util;

import com.example.entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DAO class
 *
 * @param <T> extends Entity
 */
public class EntityGoogleDriveUtil<T extends Entity> {
    //    private final List<List<Object>> mGoogleDriveData;
    protected final Map<Long, T> driveStorage;
    private long index;

    {
//        mGoogleDriveData = GoogleDriveUtil.getGoogleSpreadSheetData()
        driveStorage = new HashMap<>();
        index = 0;
    }

    public long add(final T item) {
        index++;
        item.setId(index);
        driveStorage.put(index, item);
        return index;
    }

    public T get(final long id) {
        return driveStorage.getOrDefault(id, null);
    }

    public boolean save(final T item) {
        if (!driveStorage.containsKey(item.getId())) {
            return false;
        }
        driveStorage.put(item.getId(), item);
        return true;
    }

    public boolean remove(final long id) {
        if (!driveStorage.containsKey(id)) {
            return false;
        }
        driveStorage.remove(id);
        return true;
    }

    public List<T> getAll() {
        return new ArrayList<>(driveStorage.values());
    }
}
