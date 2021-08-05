package org.pilgrim.leetcode.y2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class DjkistraMaxPropobility {

	class Edge {
		int vtx; // starting vertex
		int nbr; 
		double pb; // cost of this edge

		public Edge(int vtx, int nbr, double pb) {
			this.vtx = vtx;
			this.nbr = nbr;
			this.pb = pb;
		}
	}

	class Pair implements Comparable<Pair>{ // implementing Comparable for Priority Queue
		int vtx;
		double pbsf; // probability so far

		public Pair(int vtx, double pbsf) {
			this.vtx = vtx;
			this.pbsf = pbsf;
		}

		public int compareTo(Pair o) { 
			return Double.compare(this.pbsf, o.pbsf); // using Double.compare method becuase it computes difference with precession unlike using - which provides a lossy differnce
		}
	}

	private List<Edge>[] constructGraph (int n, int[][] edges, double[] succProb) {
		// Construct Graph 
		List<Edge>[] graph = new ArrayList[n];

		// initialize graph
		for(int i = 0; i < n; i++) {
			graph[i] = new ArrayList<Edge>();
		}

		for(int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];

			graph[u].add(new Edge(u, v, succProb[i]));
			graph[v].add(new Edge(v, u, succProb[i]));
		}
		return graph;
	}
	
	// Djkistra's Algorithm
	public double maxProbability2(int n, int[][] edges, double[] succProb, int start, int end) {

		// Construct Graph 
		List<Edge>[] graph = constructGraph(n, edges, succProb);

		boolean[] visited = new boolean[n];

		Queue<Pair> q = new PriorityQueue<>(Collections.reverseOrder()); // Max Priority Queue
		q.add(new Pair(start, 1)); // push 1st element with probability as 1
		   
		while(!q.isEmpty()) {
			Pair item = q.poll();

			if(item.vtx == end) return item.pbsf; // we have found the path that we need to reach -> return the probability of travelling on this path

			if(visited[item.vtx] == true) continue;

			visited[item.vtx] = true;

			for(Edge e : graph[item.vtx]) {
				if(visited[e.nbr] == false) q.add(new Pair(e.nbr, item.pbsf * e.pb));
			}
		}

		return 0; // there is no path available from start to end
	}
    
	
	// The fastest.
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
       double[] weights = new double[n];
        weights[start] = 1;
        for(int i = 0  ; i < n ; i ++)
        {
            int count = 0;
            for(int j = 0 ;  j < succProb.length ; j++)
            {
                int[] edge = edges[j];
                int u = edge[0];
                int  v = edge[1];
                if(weights[v] < weights[u]*succProb[j])
                {
                    weights[v] =weights[u]*succProb[j];
                    count++;
                }
                if(weights[u] < weights[v]*succProb[j])
                {
                    weights[u] =weights[v]*succProb[j];
                    count++;
                }
            }
            if(count == 0)
            {
                break;
            }
        }
        return weights[end];
    }

}