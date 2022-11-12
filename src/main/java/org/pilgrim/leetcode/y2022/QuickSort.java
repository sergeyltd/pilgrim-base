package org.pilgrim.leetcode.y2022;

public class QuickSort {

	// This class should not be instantiated.
	private QuickSort() {
	}

	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	// partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
	// and return the index j.
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];
		while (true) {

			// find item on lo to swap
			while (less(a[++i], v)) {
				if (i == hi)
					break;
			}

			// find item on hi to swap
			while (less(v, a[--j])) {
				if (j == lo)
					break; // redundant since a[lo] acts as sentinel
			}

			// check if pointers cross
			if (i >= j)
				break;

			exch(a, i, j);
		}

		// put partitioning item v at a[j]
		exch(a, lo, j);

		// now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
		return j;
	}

	/**
	 * Rearranges the array so that {@code a[k]} contains the kth smallest key;
	 * {@code a[0]} through {@code a[k-1]} are less than (or equal to) {@code a[k]};
	 * and {@code a[k+1]} through {@code a[n-1]} are greater than (or equal to)
	 * {@code a[k]}.
	 *
	 * @param a the array
	 * @param k the rank of the key
	 * @return the key of rank {@code k}
	 * @throws IllegalArgumentException unless {@code 0 <= k < a.length}
	 */
	public static Comparable select(Comparable[] a, int k) {
		if (k < 0 || k >= a.length) {
			throw new IllegalArgumentException("index is not between 0 and " + a.length + ": " + k);
		}
		
		int lo = 0, hi = a.length - 1;
		while (hi > lo) {
			int i = partition(a, lo, hi);
			if (i > k)
				hi = i - 1;
			else if (i < k)
				lo = i + 1;
			else
				return a[i];
		}
		return a[lo];
	}

	// is v < w ?
	private static boolean less(Comparable v, Comparable w) {
		if (v == w)
			return false; // optimization when reference equals
		return v.compareTo(w) < 0;
	}

	// exchange a[i] and a[j]
	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	public static void main(String[] args) {
		String[] a = { "a", "b", "z", "q" };
		QuickSort.sort(a);
		
		for (int i = 0; i < a.length; i++) {
			String ith = (String) QuickSort.select(a, i);
			System.out.println(ith);
		}
	}
}
