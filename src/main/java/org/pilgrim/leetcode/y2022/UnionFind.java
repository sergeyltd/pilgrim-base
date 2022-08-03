package org.pilgrim.leetcode.y2022;

import java.util.Arrays;
import java.util.Iterator;

public class UnionFind {

	public static void main(String[] args) {
		UnionFind uf = new UnionFind(10);
		uf.union(1, 5);
		uf.union(1, 3);
		uf.union(3, 2);
		uf.union(3, 0);
		uf.union(8, 0);
		
		uf.union(6, 7);
		
		System.out.println(Arrays.toString(uf.parents));
		
		for (int i = 0; i < 10; i++) {
			System.out.println(uf.find(i));

		}
		
		System.out.println(Arrays.toString(uf.parents));


	}
	
	int[] parents;
	
	public UnionFind(int n) {
		parents = new int[n];
		
		for(int i=0; i<n;i++) {
			parents[i] = i;
		}
	}
	
	public void union(int a, int b) {
		parents[find(b)] = find(a);
	}
	
	public int find(int a) {
		if(parents[a] == a) {
			return a;
		}
		
		return find(parents[a]);
	}

}
