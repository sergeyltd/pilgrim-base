package org.pilgrim.base;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (null == grid || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int sum = 0;

        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = grid[i][j];
                if (ch == '1') {
                    sum++;
                    bfs(grid, i, j);
                }
            }
        }

        return sum;
    }

    private int[][] d = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private void bfs(char[][] grid, int i, int j) {
        Queue<Integer[]> q = new LinkedList<>();
        Integer[] root = new Integer[] { i, j };
        q.add(root);

        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()) {
            Integer[] c = q.poll();
            grid[c[0]][c[1]] = '0';
            for (int k = 0; k < d.length; k++) {
                int ik = c[0] + d[k][0];
                int jk = c[1] + d[k][1];
                if (ik < 0 || ik >= n || jk < 0 || jk >= m) {
                    continue;
                }
                if (grid[ik][jk] == '1') {
                    Integer[] cc = new Integer[] { ik, jk };
                    q.add(cc);
                    grid[ik][jk] = '0';
                }
            }
        }
    }
}