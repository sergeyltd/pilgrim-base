package org.pilgrim.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.time.StopWatch;

/**
 * In a given integer array A, we must move every element of A to either list B
 * or list C. (B and C initially start empty.)
 * 
 * Return true if and only if after such a move, it is possible that the average
 * value of B is equal to the average value of C, and B and C are both
 * non-empty.
 * 
 * Example : Input: [1,2,3,4,5,6,7,8] Output: true Explanation: We can split the
 * array into [1,4,5,8] and [2,3,6,7], and both of them have the average of 4.5.
 * Note:
 * 
 * The length of A will be in the range [1, 30]. A[i] will be in the range of
 * [0, 10000].
 * 
 * @author segoncha
 *
 */

public class SplitArrayWithSameAverage {

	public boolean splitArraySameAverage2(int[] a) {
		if (null == a || a.length <= 0) {
			return false;
		}

		int n = a.length;

		long sum = 0;
		for (int i : a) {
			sum += i;
		}

		long tSum = 0;
		for (int i = 0; i < a.length - 1; i++) {
			tSum += a[i];
			long rSum = sum - tSum;

			// If averages of arr[0...i] and arr[i+1..n-1]
			// are same. To avoid floating point problems
			// we compare "lsum*(n-i+1)" and "rsum*(i+1)"
			// instead of "lsum/(i+1)" and "rsum/(n-i+1)"
			if (tSum * (n - i - 1) == rSum * (i + 1)) {
				return true;
			}
		}
		return false;
	}

	public boolean splitArraySameAverage3(int[] a) {
		if (null == a || a.length <= 0) {
			return false;
		}

		int n = a.length;

		long sum = 0;
		for (int i : a) {
			sum += i;
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < i+1; j++) {
				System.out.print(a[j]);
			}
			System.out.println();
		}

		long tSum = 0;
		for (int i = 0; i < a.length - 1; i++) {
			tSum += a[i];
			long rSum = sum - tSum;

			// If averages of arr[0...i] and arr[i+1..n-1]
			// are same. To avoid floating point problems
			// we compare "lsum*(n-i+1)" and "rsum*(i+1)"
			// instead of "lsum/(i+1)" and "rsum/(n-i+1)"
			if (tSum * (n - i - 1) == rSum * (i + 1)) {
				return true;
			}
		}
		return false;
	}

	public boolean splitArraySameAverage(int[] a) {
		if (null == a || a.length <= 0) {
			return false;
		}

		Arrays.sort(a);

		List<Integer> b = new ArrayList<Integer>();
		for (int i : a) {
			b.add(i);
		}

		boolean res = util(new ArrayList<>(), b);
		return res;
	}

	private boolean util(List<Integer> a, List<Integer> b) {
		boolean res = false;
		// System.out.println(Arrays.toString(a.toArray()));
		// System.out.println(Arrays.toString(b.toArray()));
		int n = a.size();
		int m = b.size();
		if (m == 0 || n > m) {
			return false;
		} else {

			if (n > 0 && m > 0) {
				double aV = avg(a);
				double bV = avg(b);

				res = aV == bV;

				if (aV > bV) {
					System.out.println(Arrays.toString(a.toArray()));
					System.out.println(Arrays.toString(b.toArray()));

					return false;
				}

				if (res) {
					return res;
				}
			}

			for (int i = 0; i < m && !res && n < m; i++) {
				List<Integer> aNew = new ArrayList<>(a);
				List<Integer> bNew = new ArrayList<>(b);
				bNew.remove(i);
				aNew.add(b.get(i));
				res = util(aNew, bNew);
			}
		}

		return res;
	}

	private double avg(List<Integer> a) {
		long sum = a.stream().mapToLong(item -> item).sum();
		return sum / ((double) a.size());
	}

	public static void main(String[] args) throws InterruptedException {
		SplitArrayWithSameAverage arrayWithSameAverage = new SplitArrayWithSameAverage();
		System.out.println(arrayWithSameAverage.splitArraySameAverage3(new int[] { 1, 5, 7, 2, 0 }));
//		// System.out.println(arrayWithSameAverage.splitArraySameAverage2(new
//		// int[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
//		StopWatch watch = new StopWatch();
//		watch.start();
//		// System.out.println(arrayWithSameAverage.splitArraySameAverage2(new
//		// int[] {1, 0, 7, 2, 5}));
//		System.out.println(arrayWithSameAverage.splitArraySameAverage(
//				new int[] { 84, 44, 32, 42, 26, 26, 87, 65, 12, 95, 68, 41, 6, 72, 8, 15, 66, 55, 71, 79, 6 }));
//		watch.stop();
//		System.out.println(watch.getTime());
//
//		// System.out.println(arrayWithSameAverage.splitArraySameAverage(new
//		// int[] { 84,44,32,42,26,26,87,65,12,95,68,41,6,72 }));
	}
}
