package org.pilgrim.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.
For example, with A = "abcd" and B = "cdabcdab".
Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
Note:
The length of A and B will be between 1 and 10000.
 * @author segoncha
 *
 */

public class RepeatedStringMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(repeatedStringMatch("abcd", "bc"));
	}

	public static int repeatedStringMatch(String a, String b) {
		if (null == a || null == b) {
			return -1;
		}

		Set<Character> listA = new HashSet<>();
		for (char ch : a.toCharArray()) {
			listA.add(ch);
		}

		Set<Character> listB = new HashSet<>();
		for (char ch : b.toCharArray()) {
			listB.add(ch);
		}

		if (listA.size() < listB.size() || !listA.containsAll(listB)) {
			return -1;
		}

		int count = 0;
		StringBuilder sb = new StringBuilder();
		do {
			sb.append(a);
			count++;

			if (sb.indexOf(b) >= 0) {
				return count;
			}
		} while (sb.length() < (2 * b.length()));
		return -1;

	}

}
