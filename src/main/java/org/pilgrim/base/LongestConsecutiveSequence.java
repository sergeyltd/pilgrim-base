package org.pilgrim.base;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	static public int lcs(int[] a) {
		if (null == a) return 0;
		if (a.length <2) return a.length;
		int max = 1;
		Set<Integer> list = new HashSet<>();
		for (int i : a) {
			list.add(i);
		}
		for (int i = 0; i < a.length; i++) {
			int count  = 1;
			int left = a[i] - 1;
			int right = a[i] + 1;
			while(list.contains(left))
			{
				list.remove(left);
				count++;
				left--;
			}
			while(list.contains(right))
			{
				list.remove(right);
				count++;
				right++;
			}
			Math.max(count, max);
		} 
		return max;
	}
}
