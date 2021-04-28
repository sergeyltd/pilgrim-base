package org.pilgrim.leetcode.y2020.amazon;

/*

Synopsis 

You are a developer for an object storage service.
Users of the service can write objects to it and
read objects from it.  Each time an object is read,
it triggers a call to objectRead(String objectId),
which passes the unique ID for the object just read.

Problem

Implement a function that will return the N most
frequently read object IDs in the service.

Interface

// Called when an object is read
void objectRead(String objectId)    <---- 

// Returns the N most frequently read objectIds
String [] mostRead(int n)            <----- 

O1 : 3
O2 : 1
O3 : 10

mostRead(1) = {"O3"};
mostRead(2) = {"O3", "O1"};

*/

static class Node implement Comparatot<Node>{
    public String objectId;
    public int freq;
    
    public Node(objectId){
        this.objectId = objectId;
    }
    
    public int compareTo(Node n1, Node n2){
        return Integer.compareTo(n2.freq, n1.freq);
    }
    
    public boolean equals(Node node){
        return this.objectId.equales(node.objectId);
    }
    
    public int hashCode(){
        return objectId.hashCode();
    }
}

public class LFMesage{
    TreeMap<Node, Object> map = new TreeNode<>();
    // Called when an object is read
void objectRead(String objId){
    if(objId == null){
        return;
    }
    
    Node node = map.get(objId);
    if(node == null){
        node = new Node(objId);
    }
    
    node.freq++; 
    map.put(node, node);
}

CPU: O(log2(n))
Memory: O(n)

read
O(1)

mostRead O(n*log2(n))

// Returns the N most frequently read objectIds
List<String> mostRead(int n){
    if(n <= 0){
        return new ArrayList<>(); 
    }
    
    List<String> list = new ArrayList<>(n);
    
    int count = 0;
    for(Node node : treeMap.keySet()){
        
        list.add(node.objectId);
        
        count++;
        if(count >= n){
            break;
        }
    }
    
    return list;
}















