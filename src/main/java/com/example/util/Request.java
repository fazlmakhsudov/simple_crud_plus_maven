package com.example.util;

import java.util.HashMap;
import java.util.Map;


public final class Request {
    private Map<String, Object> storage;

    public Request() {
        storage = new HashMap<>();
    }


    public void set(String key, Object value) {
        storage.put(key, value);

    }


    public void remove(String key) {
        if (key != null && !key.isEmpty()) {
            if (storage.containsKey(key)) {
                storage.remove(key);
            }
        }
    }


    public Object get(String key) {
        if (key != null && !key.isEmpty()) {
            if (storage.containsKey(key)) {
                return storage.get(key);
            }
        }
        return null;
    }

    public void clear() {
        storage.clear();
    }
}
