package org.pilgrim.base.array;

/**
 * Given an array of integers, rotate the array by 'N' elements.
 * 
 * @author sgoncharenko
 *
 */
public class RotateArray {
	public void rotate(int[] a, int n) {
		if(null == a || n <= 0){
			return;
		}
		int index = 0;
		int prev = a[index];
		for (int i = 0; i < a.length; i++) {
			index = (index + n) % a.length;
			int tmp = prev;
			prev = a[index]; 
			a[index] = tmp;
		}
	}
}
