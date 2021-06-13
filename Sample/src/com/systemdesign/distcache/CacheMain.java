package com.systemdesign.distcache;

import java.util.HashMap;
import java.util.Map;

public class CacheMain {
    private Map<String, Node> map;
    private final int capacity;

    CacheMain(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public String getKey(String key) {
        if (!map.containsKey(key)) {
            return null;
        }
        Node curr = map.get(key);
        deleteFromList(curr);
        addToList(curr);

        return curr.getValue();
    }

    private void addToList(Node curr) {
    }

    private void deleteFromList(Node curr) {
    }
}
