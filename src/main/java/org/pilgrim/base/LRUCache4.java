package org.pilgrim.base;
import java.util.LinkedHashMap;
import java.util.Map;
public class LRUCache4 {

    int size;
    LinkedHashMap<Integer, Integer> cache;
    public LRUCache4(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return this.size() > size;
            }        
        };
        size = capacity;
    }
    
    public int get(int key) {
        Integer res = cache.get(key);
        return res == null ? -1 : res;
    }
    
    public void put(int key, int value) {
        cache.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */