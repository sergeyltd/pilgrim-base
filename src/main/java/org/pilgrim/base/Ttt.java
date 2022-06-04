package org.pilgrim.base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Ttt {
	public static class Node implements Comparable<Node>{
        public int key;
        public int freq;
        
        public Node(int k, int f){
            this.key = k;
            this.freq = f;
            
            StringBuilder sb;
            sb.delete(k, f);
            String[] u = "".split("");
            List<String> ll;
            ll.addAll(Arrays.asList(null));
        }
        
        public int compareTo(Node o) {
            int res = Integer.compare(freq, o.freq);
            return res;
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        // Check input values
        if(nums == null || nums.length <= 0 || k <= 0){
            return null;
        }
        
        Map<Integer, Node> map = new HashMap<>();
        for(int a : nums){
            map.putIfAbsent(a, new Node(a, 0));
            Node node = map.get(a);
            node.freq++;
            map.put(a, node);
        }
        
        Queue<Node> q = new PriorityQueue<>();
        Set<Entry<Integer, Node>> mapSet = map.entrySet();
		for (Entry<Integer, Node> entry : mapSet) {
			q.add(entry.getValue());
		}
        
        int i = 0;
        int[] res = new int[k];
        while(!q.isEmpty() && k > 0){
            res[i++] = q.poll().key;
        }
        
        return res;
    }

}
