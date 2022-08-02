package org.pilgrim.leetcode.y2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import org.apache.commons.lang3.tuple.Pair;

class NetworkDelayTime {
	
	public static void main(String[] args) {
		
		System.out.println("abc".substring(0,1));
		
		NetworkDelayTime networkDelayTime = new NetworkDelayTime();
		
		int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
		int n = 4;
		int k = 2;
		
		System.out.println(networkDelayTime.networkDelayTime(times, n, k));
		System.out.println(networkDelayTime.networkDelayTime2(times, n, k));
		
	}
	
    Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();
    
    public int networkDelayTime2(int[][] times, int n, int k) {
        Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();
        
        for(int i=0; i<times.length; i++){
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            adj.putIfAbsent(u, new ArrayList<Pair<Integer, Integer>>());
            
            List<Pair<Integer, Integer>> list = adj.get(u);
            list.add(Pair.of(w, v));
            
            System.arraycopy(adj, v, list, w, n);
        }
        
        if(!adj.containsKey(k)){
            return -1;
        }
        
        boolean[] visited = new boolean[n + 1];
        visited[0] = true;
        
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        distance[0] = 0;
        
        Queue<Pair<Integer, Integer>> mh = new PriorityQueue<>(Comparator.comparing(Pair::getKey));
        mh.add(Pair.of(0, k));
        
        while(!mh.isEmpty()){
            Pair<Integer, Integer> p = mh.poll();
            int w = p.getKey();
            int u = p.getValue();
            
            visited[u] = true;
            
            if(distance[u] < w) {
            	continue;
            }
            
            List<Pair<Integer, Integer>> children = adj.get(u);
            if(children == null)
            {
                continue;
            }
            
            for(Pair<Integer, Integer> child : children){
                int node = child.getValue();
                int d = child.getKey() + w;
                if(visited[node]){
                    continue;
                }
                
                if(d < distance[node]){
                    distance[node] = d;
                    mh.add(Pair.of(d, node));
                }
            }
        }
        
//         for(boolean vis : visited){
//             if(!vis){
//                 return -1;
//             }
//         }
        
        int max = 0;
        for(int d : distance){
            max = Math.max(d, max);
        }
        
        return max == Integer.MAX_VALUE ? -1 : max;
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        for(int i = 0; i<times.length; i++){
            // Source
            int u = times[i][0];
            
            // Destination
            int v = times[i][1];
            
            // Weight
            int w = times[i][2];
            
            this.adj.putIfAbsent(u, new ArrayList<>());
            this.adj.get(u).add(Pair.of(w, v));
        }
        
        int[] signalReceivedAt = new int[n+1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);
        
        this.dijkstra(signalReceivedAt, k);
        
        int ans = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            ans = Math.max(signalReceivedAt[i], ans);
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    private void dijkstra(int[] signalReceivedAt, int source) {
        Queue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer,Integer>>
            (Comparator.comparing(Pair::getKey));
        pq.add(Pair.of(0, source));
        
        // Time for starting node is 0
        signalReceivedAt[source] = 0;
        
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> topPair = pq.remove();
            
            int currNode = topPair.getValue();
            int currNodeTime = topPair.getKey();
            
            if (currNodeTime > signalReceivedAt[currNode]) {
                continue;
            }
            
            if (!adj.containsKey(currNode)) {
                continue;
            }
            
            // Broadcast the signal to adjacent nodes
            for (Pair<Integer, Integer> edge : adj.get(currNode)) {
                int time = edge.getKey();
                int neighborNode = edge.getValue();
                
                // Fastest signal time for neighborNode so far
                // signalReceivedAt[currNode] + time : 
                // time when signal reaches neighborNode
                if (signalReceivedAt[neighborNode] > currNodeTime + time) {
                    signalReceivedAt[neighborNode] = currNodeTime + time;
                    pq.add(Pair.of(signalReceivedAt[neighborNode], neighborNode));
                }
            }
        }
    }
}