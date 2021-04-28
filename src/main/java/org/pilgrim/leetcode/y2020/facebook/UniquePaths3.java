package org.pilgrim.leetcode.y2020.facebook;

public class UniquePaths3 {

   	static int[][] d = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
	int res = 0;
	int maxPath = 0;
	int[][] startPoint = new int[1][2];
	int[][] endPoint = new int[1][2];

	public int uniquePathsIII(int[][] grid) {
		if (grid == null || grid.length <= 0 || grid[0].length <= 0) {
			return 0;
		}

		int n = grid.length;
		int m = grid[0].length;

		int numberFreeSpace = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int c = grid[i][j];
				if (c == 0) {
					numberFreeSpace++;
				} else if (c == 1) {
					startPoint[0][0] = i;
					startPoint[0][1] = j;
				} else if (c == 2) {
					endPoint[0][0] = i;
					endPoint[0][1] = j;
				}
			}
		}

		maxPath = numberFreeSpace + 1;

		int pathLength = 0;
		backtrack(grid, startPoint[0][0], startPoint[0][1], pathLength);

		return res;
	}

	private void backtrack(int[][] g, int col, int row, int p) {
		int n = g.length;
		int m = g[0].length;

		if (col < 0 || col >= n) {
			return;
		}
		if (row < 0 || row >= m) {
			return;
		}

		if (g[col][row] == -1) {
			return;
		}

		if (g[col][row] == 2) {
			if (p >= maxPath) {
				res++;
			}
			return;
		}

		int last = g[col][row];
		g[col][row] = -1;

		for (int k = 0; k < d.length; k++) {
			backtrack(g, col + d[k][0], row + d[k][1], p + 1);
		}

		g[col][row] = last;
	}

	public static void main(String[] args) {
		UniquePaths3 uniquePaths3 = new UniquePaths3();
		int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
		int numbers = uniquePaths3.uniquePathsIII(grid);
		System.out.println(numbers);
	}
}
