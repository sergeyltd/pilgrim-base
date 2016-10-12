package org.pilgrim.base;

public class ZigZag {
	public int longestZigZag(int[] a) {
		if (a.length == 1)
			return 1;
		int[] v = new int[a.length - 1];
		for (int i = 1; i < a.length; i++) {
			v[i - 1] = a[i] - a[i - 1];
		}
		// dir is first nonzero
		int j = 0;
		while (j < v.length && v[j] == 0)
			j++;
		if (j == v.length)
			return 1;
		int dir = v[j];
		int len = 2;
		for (int i = j + 1; i < v.length; i++) {
			if (v[i] * dir < 0) {
				dir *= -1;
				len++;
			}
		}
		return len;
	}
};