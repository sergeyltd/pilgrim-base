package org.pilgrim.leetcode.y2021;

import java.util.List;

public class FormingMagicSquare {
    
    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    public static int formingMagicSquare(List<List<Integer>> s) {
        // Write your code here
            // Write your code here
        int res = 0;
        
        int[][] magic = new int [][] {{8, 1, 6, 3, 5, 7, 4, 9, 2},
         {6, 1, 8, 7, 5, 3, 2, 9, 4},
            {4, 3, 8, 9, 5, 1, 2, 7, 6}, {2, 7, 6, 9, 5, 1, 4, 3, 8},
            {2, 9, 4, 7, 5, 3, 6, 1, 8}, {4, 9, 2, 3, 5, 7, 8, 1, 6},
            {6, 7, 2, 1, 5, 9, 8, 3, 4}, {8, 3, 4, 1, 5, 9, 6, 7, 2}};
        
        int[] input = new int[9];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                input[i*3 + j] = s.get(i).get(j);
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<8; i++){
            int r = 0;
            for(int j=0; j<9; j++){
                r += Math.abs(magic[i][j] - input[j]);
            }
            
            min = Math.min(min, r);
        }
        
        return min;
    }

    public static void main(String[] args) {
        double b = 2.000000001;
        
        System.out.println(Math.round(b - 0.5));
        System.out.println(Math.ceil(b));
        
    }

}