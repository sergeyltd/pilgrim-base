package org.pilgrim.leetcode.y2022;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * 261. Graph Valid Tree Medium
 * 
 * 2598
 * 
 * 74
 * 
 * Add to List
 * 
 * Share You have a graph of n nodes labeled from 0 to n - 1. You are given an
 * integer n and a list of edges where edges[i] = [ai, bi] indicates that there
 * is an undirected edge between nodes ai and bi in the graph.
 * 
 * Return true if the edges of the given graph make up a valid tree, and false
 * otherwise.
 *
 */

public class GraphValidTree {

	public static void main(String[] args) {

	}

	public boolean validTree(int n, int[][] edges) {

		if (edges.length != n - 1)
			return false;

		// Make the adjacency list.
		List<List<Integer>> adjacencyList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjacencyList.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			adjacencyList.get(edge[0]).add(edge[1]);
			adjacencyList.get(edge[1]).add(edge[0]);
		}

		Stack<Integer> stack = new Stack<>();
		Set<Integer> seen = new HashSet<>();
		stack.push(0);
		seen.add(0);

		while (!stack.isEmpty()) {
			int node = stack.pop();
			for (int neighbour : adjacencyList.get(node)) {
				if (seen.contains(neighbour))
					continue;
				seen.add(neighbour);
				stack.push(neighbour);
			}
		}

		return seen.size() == n;
	}
}
