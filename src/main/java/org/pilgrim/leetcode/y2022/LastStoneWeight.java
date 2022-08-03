package org.pilgrim.leetcode.y2022;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * 1046. Last Stone Weight Easy
 * 
 * 3494
 * 
 * 69
 * 
 * Add to List
 * 
 * Share You are given an array of integers stones where stones[i] is the weight
 * of the ith stone.
 * 
 * We are playing a game with the stones. On each turn, we choose the heaviest
 * two stones and smash them together. Suppose the heaviest two stones have
 * weights x and y with x <= y. The result of this smash is:
 * 
 * If x == y, both stones are destroyed, and If x != y, the stone of weight x is
 * destroyed, and the stone of weight y has new weight y - x. At the end of the
 * game, there is at most one stone left.
 * 
 * Return the weight of the last remaining stone. If there are no stones left,
 * return 0.
 *
 */

public class LastStoneWeight {

	public static void main(String[] args) {

	}

	public int lastStoneWeight(int[] stones) {
		if (stones == null || stones.length <= 0) {
			return 0;
		}

		Queue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < stones.length; i++) {
			maxH.add(stones[i]);
		}

		while (maxH.size() > 1) {
			int y = maxH.poll();
			int x = maxH.poll();

			int z = y - x;
			if (z == 0) {
				continue;
			}

			maxH.add(z);
		}

		return maxH.isEmpty() ? 0 : maxH.peek();
	}

}
