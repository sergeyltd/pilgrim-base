package org.pilgrim.base.array;

//Given three integer arrays sorted in ascending order, find the smallest number that is common in all three arrays.
public class FindSmallestCommonNumber {

	public int findCommonMinimum(int[] a, int[] b, int[] c) {
		int min = Integer.MIN_VALUE;

		for (int i = 0, j = 0, k = 0; i < a.length && j < b.length && k < c.length;) {
			if (a[i] == b[j] && b[j] == c[k]) {
				min = a[i];
				break;
			}

			if (a[i] < b[j]) {
				i++;
			} else if (b[j] < c[k]) {
				j++;
			} else {
				k++;
			}
		}

		return min;
	}
}
