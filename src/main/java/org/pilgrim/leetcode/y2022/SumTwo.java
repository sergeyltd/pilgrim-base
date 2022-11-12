package org.pilgrim.leetcode.y2022;

import java.util.HashMap;
import java.util.Map;

public class SumTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length <= 0) {
			return null;
		}

		// Map value, index
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int a = nums[i];
			int b = target - a;

			Integer index = map.get(b);
			if (index != null) {
				return new int[] { i, index };
			}

			map.put(a, i);
		}

		return null;
	}

}
