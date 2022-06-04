package org.pilgrim.leetcode.y2022;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 
 * 2280. Minimum Lines to Represent a Line Chart
Medium

115

280

Add to List

Share
You are given a 2D integer array stockPrices where stockPrices[i] = [dayi, pricei] indicates the price of the stock on day dayi is pricei. A line chart is created from the array by plotting the points on an XY plane with the X-axis representing the day and the Y-axis representing the price and connecting adjacent points. One such example is shown below:


Return the minimum number of lines needed to represent the line chart.

 

Example 1:


Input: stockPrices = [[1,7],[2,6],[3,5],[4,4],[5,4],[6,3],[7,2],[8,1]]
Output: 3
Explanation:
The diagram above represents the input, with the X-axis representing the day and Y-axis representing the price.
The following 3 lines can be drawn to represent the line chart:
- Line 1 (in red) from (1,7) to (4,4) passing through (1,7), (2,6), (3,5), and (4,4).
- Line 2 (in blue) from (4,4) to (5,4).
- Line 3 (in green) from (5,4) to (8,1) passing through (5,4), (6,3), (7,2), and (8,1).
It can be shown that it is not possible to represent the line chart using less than 3 lines.
Example 2:


Input: stockPrices = [[3,4],[1,2],[7,8],[2,3]]
Output: 1
Explanation:
As shown in the diagram above, the line chart can be represented with a single line.
 

Constraints:

1 <= stockPrices.length <= 105
stockPrices[i].length == 2
1 <= dayi, pricei <= 109
All dayi are distinct.
Accepted
9,917
Submissions
51,460
 * 
 */

public class MinimumLinesRepresentLineChart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minimumLines(int[][] stockPrices) {
        /*
        a - slope
        y = ax + b
        
        b = y1 - ax1
        y2 = ax2 + y1 - ax1
        
        y2 - y1 = a(x2 - x1)
        a = (y2 - y1) / (x2 - x1)
        */
        
        // Check input values
        if(stockPrices == null || stockPrices.length <= 1){
            return 0;
        }
        
        // Arrays.sort(stockPrices, new Comparator<int[]>() {
        //     public int compare(int[] obj1, int[] obj2){
        //         return Integer.compare(obj1[0], obj2[0]);
        //     }
        // });
        
        Arrays.sort(stockPrices, (a,b)->a[0]-b[0]);
        
        int count = 1;
        for(int i=2;i<stockPrices.length;i++){
            long x1 = stockPrices[i-2][0],y1 = stockPrices[i-2][1];
            long x2 = stockPrices[i-1][0],y2 = stockPrices[i-1][1];
            long x3 = stockPrices[i][0],y3 = stockPrices[i][1];
            
            //avoid finding individual slope with division to avoid floating point errors
            long diff1 = (y2-y1)*(x3-x2);
            long diff2 = (y3-y2)*(x2-x1);
            if(diff1!=diff2){
                count++;
            }
        }
        
        return count;
    }

}
