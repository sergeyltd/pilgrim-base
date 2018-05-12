package org.pilgrim.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Plus One Given a non-empty array of digits representing a non-negative
 * integer, plus one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list, and each element in the array contain a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example 1:
 * 
 * Input: [1,2,3] Output: [1,2,4] Explanation: The array represents the integer
 * 123. Example 2:
 * 
 * Input: [4,3,2,1] Output: [4,3,2,2] Explanation: The array represents the
 * integer 4321.
 * 
 * @author segoncha
 *
 */
public class PlusOne {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(plusOne(new int[] { 1, 2, 3 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 9, 9, 9, 0 })));
	}

	public static int[] plusOne(int[] digits) {

		if (null == digits || digits.length == 0) {
			return new int[0];
		}

		int d = 0;
		List<Integer> list = new ArrayList<>(digits.length + 1);
		
		for (int i = 0; i < digits.length-1; i++) {
			list.add(digits[i]);
		}
		list.add(digits[digits.length-1] + 1);
		
		for (int i = list.size() - 1; i >= 0; i--) {
			list.set(i, list.get(i) + d);
			Integer n = list.get(i);
			d = n / 10;
			int r = n % 10;
			list.set(i, r);
		}

		if (d > 0) {
			list.add(0, d);
		}

		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}
