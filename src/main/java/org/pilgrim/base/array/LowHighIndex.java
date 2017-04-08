package org.pilgrim.base.array;

/**
 * Find low/high index
 * 
 * @author sgoncharenko
 *
 */
public class LowHighIndex {
	public int[] find(int[] a, int x) {
		if (null == a || a.length <= 0) {
			return new int[] { -1 };
		}
		int index = binarySearch(a, x);
		if (0 > index) {
			return new int[] { -1 };
		}

		int rightIndex = index;
		for (rightIndex = index; rightIndex < a.length - 1 && a[rightIndex] == a[rightIndex + 1]; rightIndex++)
			;

		int leftIndex = index;
		for (leftIndex = index; leftIndex > 0 && a[leftIndex] == a[leftIndex - 1]; leftIndex--)
			;

		return new int[] { leftIndex, rightIndex };
	}

	private int binarySearch(int[] a, int x) {
		int i = 0;
		int j = a.length - 1;

		while (i <= j) {
			int mid = (j + i) / 2;
			int midVal = a[mid];

			if (midVal < x) {
				i = mid + 1;
			} else if (midVal > x) {
				j = mid - 1;
			} else {
				return mid;
			}
		}

		return -(i + 1);
	}
}
