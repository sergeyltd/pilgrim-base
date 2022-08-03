package org.pilgrim.leetcode.y2022;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 *
 */

public class KclosestPointToOrigin {

	public static void main(String[] args) {

	}

	public int[][] kClosest(int[][] points, int k) {
		if (points == null || points.length <= 0 || k <= 0) {
			return null;
		}

		Arrays.sort(points, (a, b) -> Long.compare((a[0] * a[0] + a[1] * a[1]), (b[0] * b[0] + b[1] * b[1])));
		return Arrays.copyOf(points, k);
	}

	public int[][] kClosest2(int[][] points, int k) {
		if (points == null || points.length <= 0 || k <= 0) {
			return null;
		}

		Queue<int[]> q = new PriorityQueue<>(
				(a, b) -> Long.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1])));

		for (int i = 0; i < points.length; i++) {
			q.add(points[i]);
			if (q.size() > k) {
				q.poll();
			}
		}

		int j = 0;
		int[][] ans = new int[q.size()][2];
		while (!q.isEmpty()) {
			ans[j++] = q.poll();
		}

		return ans;
	}
}
