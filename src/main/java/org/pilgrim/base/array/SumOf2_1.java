package org.pilgrim.base.array;

import java.util.HashSet;
import java.util.Set;

public class SumOf2_1 {
	// find_sum_of_two function return true if
	// there are two values in array who
	// sum to value and returns false otherwise
	static boolean find_sum_of_two(int[] A, int val) {
		Set<Integer> found_values = new HashSet<>();
		for (int a : A) {
			if (found_values.contains(val - a)) {
				return true;
			}

			found_values.add(a);
		}

		return false;
	}
}
