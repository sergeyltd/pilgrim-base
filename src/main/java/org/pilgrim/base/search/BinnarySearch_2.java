package org.pilgrim.base.search;

public class BinnarySearch_2 {
	static int binary_search_iterative(int[] A, int key) {

		int low = 0;
		int high = A.length - 1;

		while (low <= high) {

			int mid = low + ((high - low) / 2);

			if (A[mid] == key) {
				return mid;
			}

			if (key < A[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return -1;
	}
}
