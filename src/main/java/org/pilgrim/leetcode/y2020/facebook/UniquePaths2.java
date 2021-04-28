package org.pilgrim.leetcode.y2020.facebook;

public class UniquePaths2 {

	public int uniquePathsWithObstacles(int[][] grid) {
		if (grid == null || grid.length <= 0 || grid[0].length <= 0 || grid[0][0] == 1) {
			return 0;
		}

		int n = grid.length;
		int m = grid[0].length;
        
        grid[0][0] = 1;
        
        for(int i=1; i<n; i++){
            int t = getTop(grid, i, 0);
            int l = getLeft(grid, i, 0);                
            
            if(grid[i][0] == 1){
                grid[i][0] = 0;
            }
            else{
                grid[i][0] = t + l;
            }
        }
        
        for(int j=1; j<m; j++){
            int t = getTop(grid, 0, j);
            int l = getLeft(grid, 0, j);                
            
            if(grid[0][j] == 1){
                grid[0][j] = 0;
            }
            else{
                grid[0][j] = t + l;
            }
        }

		for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                int t = getTop(grid, i, j);
                int l = getLeft(grid, i, j);                
                
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                }
                else{
                    grid[i][j] = t + l;
                }
            }
        }

		return grid[n-1][m-1];
	}   
    
    private int getTop(int[][] grid, int i, int j){
        int n = grid.length;
		int m = grid[0].length;
        
        i = i - 1;
        
        if(i >= n || i < 0){
            return 0;
        }
        
        
        return grid[i][j];
    }    
        
    private int getLeft(int[][] grid, int i, int j){
        int n = grid.length;
		int m = grid[0].length;
        
        j = j - 1;
        
        if(j >= m || j < 0){
            return 0;
        }
        
        
        return grid[i][j];
    }

	public static void main(String[] args) {
		UniquePaths2 uniquePaths3 = new UniquePaths2();
		int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
		int numbers = uniquePaths3.uniquePathsWithObstacles(grid);
		System.out.println(numbers);
	}
}
