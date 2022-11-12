package org.pilgrim.base;

import java.util.HashMap;
import java.util.Map;

public class LFUCache3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        LFUCache3 lfu = new LFUCache3(2);
        lfu.put(1, 10);
        lfu.put(2, 20);
        lfu.get(1);
        lfu.put(3, 30);
        lfu.get(2);
        lfu.get(3);
    }

    class Node{
        Node prev;
        Node next;
        int key;
        int val;
        
        public String toString(){
            return "[" + key + ":" + val + "]";
        }
    }
    
    class NodeList{
        Node head;
        Node tail;
        
        public NodeList(){
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }
        
        public String toString(){
            return "head: " + head + " tail:" + tail;
        }
        
        public void delete(Node item){
            item.next.prev = item.prev;
            item.prev.next = item.next;
        }
        
        public void append(Node item){
            item.next = head.next;
            item.prev = head;
            head.next = item;
            item.next.prev = item;
        }
    }
    
    class Item{
        Node node;
        int freq;
        // NodeList list;
        
        public String toString(){
            return "node: " + node + " freq: " + freq;
        }
    }
    
    int minFreq = 0;
    int capacity;
    Map<Integer, Item> mapNode = new HashMap<>();
    Map<Integer, NodeList> mapFreq = new HashMap<>();
    
    public LFUCache3(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Map<Integer, Item> mapNode1 = this.mapNode;
        Map<Integer, NodeList> mapFreq1 = this.mapFreq;
        
        Item item = mapNode.get(key);
        if(item == null){
            return -1;
        }
        
        NodeList list = mapFreq.get(item.freq);
        list.delete(item.node);
        
        if(list.head.next == list.tail && list.head == list.tail.prev){
            mapFreq.remove(item.freq);
            
            if(item.freq == this.minFreq){
                this.minFreq++;
            }
        }
        
        list = mapFreq.get(++item.freq);
        if(list == null){
            list = new NodeList();
            mapFreq.put(item.freq, list);
        }
        list.append(item.node);
        
        return item.node.val;
    }
    
    public void put(int key, int value) {
        
        if(capacity <= 0){
            return;
        }
        
        Map<Integer, Item> mapNode1 = this.mapNode;
        Map<Integer, NodeList> mapFreq1 = this.mapFreq;
        int minF = this.minFreq;
        
        Item item = mapNode.get(key);
        if(item != null){
            item.node.val = value;
            NodeList list = mapFreq.get(item.freq);
            Node node = item.node;
            list.delete(node);
            list.append(node);
            return;
        }
        
        if(mapNode.size() == this.capacity){
            NodeList list = mapFreq.get(this.minFreq);
            Node node = list.tail.prev;
            mapNode.remove(node.key);
            list.delete(node);
            
            if(list.head.next == list.tail && list.head == list.tail.prev){
                mapFreq.remove(this.minFreq);
            }
        }
        
        this.minFreq = 0;
        Node node = new Node();
        node.val = value;
        node.key = key;
        
        item = new Item();
        item.freq = 0;
        item.node = node;
        
        mapNode.put(key, item);
        
        NodeList list = mapFreq.get(this.minFreq);
        if(list == null) {
            list = new NodeList();
            mapFreq.put(this.minFreq, list);
        }
        
        list.append(node);
    }
}


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
