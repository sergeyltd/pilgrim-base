package org.pilgrim.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * Example 1:
 * 
 * Input: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 * 
 * Input: [ [1, 2, 3, 4], [5, 6, 7, 8], [9,10,11,12] ] Output:
 * [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * @author segoncha
 *
 */
public class SpiralMatrix {
	public static void main(String[] args) {
	}

	public List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> list = new ArrayList<>();

		if (matrix == null || matrix.length == 0) {
			return list;
		}

		int m = matrix.length;
		int n = matrix[0].length;

		int x = 0;
		int y = 0;

		while (n > 0 && m > 0) {

			if (m == 1) {
				for (int i = 0; i < n; i++) {
					list.add(matrix[x][y++]);
				}
				break;
			}
			if (n == 1) {
				for (int i = 0; i < m; i++) {
					list.add(matrix[x++][y]);
				}
				break;
			}

			// top - move right
			for (int i = 0; i < n - 1; i++) {
				list.add(matrix[x][y++]);
			}

			// right - move down
			for (int i = 0; i < m - 1; i++) {
				list.add(matrix[x++][y]);
			}

			// bottom - move left
			for (int i = 0; i < n - 1; i++) {
				list.add(matrix[x][y--]);
			}

			// left - move up
			for (int i = 0; i < m - 1; i++) {
				list.add(matrix[x--][y]);
			}

			x++;
			y++;
			m -= 2;
			n -= 2;
		}

		return list;
	}
}
