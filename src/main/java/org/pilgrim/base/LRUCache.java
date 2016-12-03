package org.pilgrim.base;

import java.util.LinkedHashMap;
import java.util.Map;


public class LRUCache {
    static int c = 0;
    LinkedHashMap<Integer, Integer> queue;

    public LRUCache(int capacity) {
        queue = new LinkedHashMap<Integer, Integer>() {
            private static final long serialVersionUID = 1L;

            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return this.size() > capacity;
            }

            @Override
            public Integer put(Integer key, Integer value) {
                remove(key);
                return super.put(key, value);
            }

            @Override
            public Integer get(Object key) {
                Integer value = remove(key);
                if (null != value) {
                    super.put((Integer) key, value);
                }
                return value;
            }
        };
    }

    public int get(int key) {
        Integer v = queue.get(key);
        // System.out.print("get "+ (++c) + ". key:" + key);
        // System.out.println(" value:" + v);
        if (null == v) {
            return -1;
        }
        return v;
    }

    public void set(int key, int value) {
        queue.put(key, value);
        // System.out.print("set "+ (++c) + ". key:" + key);
        // System.out.println(" value:" + value);
    }
}