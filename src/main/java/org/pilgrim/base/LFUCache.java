package org.pilgrim.base;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;

public class LFUCache {

    public AtomicLong atomicLong = new AtomicLong(0);

    private static class CacheNode implements Comparable<CacheNode> {
        public int key;
        public int val;
        public long ts;
        public int frequent;

        @Override
        public int compareTo(CacheNode o) {
            int res = Integer.compare(frequent, o.frequent);
            if (0 == res) {
                res = Long.compare(ts, o.ts);
            }
            return res;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + key;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            CacheNode other = (CacheNode) obj;
            if (key != other.key)
                return false;
            return true;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[key=");
            builder.append(key);
            builder.append(", val=");
            builder.append(val);
            builder.append(", ts=");
            builder.append(ts);
            builder.append(", frequent=");
            builder.append(frequent);
            builder.append("]");
            return builder.toString();
        }
    }

    TreeMap<CacheNode, CacheNode> treeMap = new TreeMap<>();
    Map<Integer, CacheNode> cach = new HashMap<>();
    private int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        int res = -1;

        if (0 >= capacity) {
            return res;
        }

        CacheNode node = cach.get(key);
        if (null != node) {
            treeMap.remove(node);
            node.frequent++;
            node.ts = atomicLong.getAndIncrement();
            treeMap.put(node, node);
            res = node.val;
        }
        return res;
    }

    public void set(int key, int value) {
        if (0 >= capacity) {
            return;
        }

        int size = treeMap.size();
        if (capacity <= size && !cach.containsKey(key)) {
            CacheNode firstKey = treeMap.firstKey();
            if (null != firstKey) {
                treeMap.remove(firstKey);
                cach.remove(firstKey.key);
            }
        }else if(cach.containsKey(key)){
            CacheNode node = cach.get(key);
            treeMap.remove(node);
            node.frequent++;
            node.ts = atomicLong.getAndIncrement();
            node.val = value;
            treeMap.put(node, node);
            return;
        }

        CacheNode node = new CacheNode();
        node.key = key;
        node.val = value;
        node.ts = atomicLong.getAndIncrement();
        node.frequent = 0;

        cach.put(key, node);
        treeMap.put(node, node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such: LFUCache obj =
 * new LFUCache(capacity); int param_1 = obj.get(key); obj.set(key,value);
 */