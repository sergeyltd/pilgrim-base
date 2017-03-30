package org.pilgrim.base.search;

public class BinnarySearch_1 {
	static int binary_search_rec(int[] a, int key, int low, int high) {
		if (low > high) {
			return -1;
		}

		int mid = low + ((high - low) / 2);
		if (a[mid] == key) {
			return mid;
		} else if (key < a[mid]) {
			return binary_search_rec(a, key, low, mid - 1);
		} else {
			return binary_search_rec(a, key, mid + 1, high);
		}
	}

	static int bin_search(int[] a, int key) {
		return binary_search_rec(a, key, 0, a.length - 1);
	}
}
