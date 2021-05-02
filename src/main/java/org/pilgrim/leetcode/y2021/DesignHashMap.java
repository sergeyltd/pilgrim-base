package org.pilgrim.leetcode.y2021;

import java.util.Iterator;
import java.util.LinkedList;

class DesignHashMap {
      int key;
      int val;
}

class MyHashMap {
    
    LinkedList<DesignHashMap>[] arr = new LinkedList[1000];

    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int size = arr.length;
        int index = key % size;
        
        LinkedList<DesignHashMap> map = arr[index];
        if(map == null){
            map = new LinkedList<DesignHashMap>();
            arr[index] = map;
        }
        
        DesignHashMap found = null;
        int i = -1;
        Iterator<DesignHashMap> iterator = map.iterator();
        while (iterator.hasNext()) {
            DesignHashMap kv = iterator.next();
            i++;
            if(kv.key == key){
                found = kv;
                break;
            }
        }
        
        if(found != null){
            found.val = value;
        }
        else{
            DesignHashMap kv = new DesignHashMap();
            kv.key = key;
            kv.val = value;
            map.add(kv);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int size = arr.length;
        int index = key % size;
        
        LinkedList<DesignHashMap> map = arr[index];
        if(map == null){
            return -1;
        }
        
        DesignHashMap found = null;
        Iterator<DesignHashMap> iterator = map.iterator();
        while (iterator.hasNext()) {
            DesignHashMap kv = iterator.next();
            if(kv.key == key){
                found = kv;
                break;
            }
        }
        
        if(found != null){
            return found.val;
        }
        else{
            return -1;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int size = arr.length;
        int index = key % size;
        
        LinkedList<DesignHashMap> map = arr[index];
        if(map == null){
            return;
        }
        
        DesignHashMap found = null;
        Iterator<DesignHashMap> iterator = map.iterator();
        while (iterator.hasNext()) {
            DesignHashMap kv = iterator.next();
            if(kv.key == key){
                iterator.remove();
                break;
            }
        }
        
        if(map.isEmpty()){
            arr[index] = null;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */