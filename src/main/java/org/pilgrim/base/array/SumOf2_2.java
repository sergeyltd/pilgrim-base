package org.pilgrim.base.array;

public class SumOf2_2 {
	// find_sum_of_two_2 function return true if
	// there are two values in array who
	// sum to value and returns false otherwise
	// this solution works only if data is sorted.
	// does not require any extra memory.
	static boolean find_sum_of_two_2(int[] A, int val) {
		for (int i = 0, j = A.length - 1; i < j;) {
			int sum = A[i] + A[j];
			if (sum == val) {
				return true;
			}

			if (sum < val) {
				++i;
			} else {
				--j;
			}
		}

		return false;
	}
}
