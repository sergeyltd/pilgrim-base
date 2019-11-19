package org.pilgrim.base;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class LFUCache2 {

    Map<Integer, Integer> data = new HashMap<>();
    TreeMap<Integer, LinkedHashSet<Integer>> freqMap = new TreeMap<>();
    Map<Integer, Integer> freqKeyMap = new HashMap<>();
    int size;

    public LFUCache2(int capacity) {
        size = capacity;
    }

    public int get(int key) {
        Integer val = data.get(key);
        if (val == null) {
            return -1;
        }
        ReCountFreq(key);

        return val;
    }

    public void put(int key, int value) {
        if (!data.containsKey(key) && data.size() == size) {
            Entry<Integer, LinkedHashSet<Integer>> entry = freqMap.firstEntry();
            Iterator<Integer> it = entry.getValue().iterator();
            Integer keyDel = it.next();
            it.remove();
            if (entry.getValue().isEmpty()) {
                freqMap.pollFirstEntry();
            }
            data.remove(keyDel);
            freqKeyMap.remove(keyDel);
        }

        data.put(key, value);
        ReCountFreq(key);
    }

    private void ReCountFreq(int key) {
        Integer freq = freqKeyMap.get(key);
        if (freq == null) {
            freq = 1;
        } else {
            LinkedHashSet<Integer> freqList = freqMap.get(freq);
            if (freqList != null) {
                freqList.remove(key);
                if (freqList.isEmpty()) {
                    freqMap.remove(freq);
                }
                freq++;
            }
        }

        LinkedHashSet<Integer> freqList = freqMap.get(freq);
        if (freqList == null) {
            freqList = new LinkedHashSet<Integer>();
            freqMap.put(freq, freqList);
        }
        freqList.add(key);
        freqKeyMap.put(key, freq);
    }

    public static void main(String[] args) {
        LFUCache2 lfu = new LFUCache2(2);
        lfu.put(1, 10);
        lfu.put(2, 20);
        lfu.put(1, 11);
        lfu.put(1, 12);
        lfu.get(1);
        lfu.get(2);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such: LFUCache obj =
 * new LFUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */