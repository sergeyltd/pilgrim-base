package org.pilgrim.base;

import java.util.HashMap;

public class LRUCache2 {
    private static class CacheNode {
        public Integer key;
        public Integer val;
        public CacheNode prev;
        public CacheNode next;
    }

    private HashMap<Integer, CacheNode> map = new HashMap<Integer, CacheNode>();
    private CacheNode listHead = new CacheNode();
    private int capacity;

    public LRUCache2(final int capacity) {
        this.capacity = capacity;
        listHead.prev = listHead;
        listHead.next = listHead;
    }

    public int get(int key) {
        Integer okey = new Integer(key);
        CacheNode node = map.get(okey);
        if (node == null) {
            return -1;
        } else {
            removeNode(node);
            addFirst(node);
            return node.val.intValue();
        }
    }

    public void set(int key, int value) {
        Integer okey = new Integer(key);
        CacheNode node = map.get(okey);
        if (node != null) {
            // remove the CacheNode
            node.val = value;
            removeNode(node);
        } else {
            node = new CacheNode();
            node.key = new Integer(key);
            node.val = new Integer(value);
        }
        addFirst(node);
        map.put(okey, node);
        if (map.size() > capacity) {
            Integer least = listHead.prev.key;
            map.remove(least);
            // remove the last element in the list
            removeLastNode();
        }
    }

    private void removeNode(CacheNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void removeLastNode() {
        listHead.prev.prev.next = listHead;
        listHead.prev = listHead.prev.prev;
    }

    private void addFirst(CacheNode node) {
        node.next = listHead.next;
        node.prev = listHead;
        listHead.next.prev = node;
        listHead.next = node;
    }
}