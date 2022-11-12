package org.pilgrim.leetcode.y2022;

import java.util.Stack;

public class LargestRectangleHistogram {

    public int largestRectangleArea(int[] heights) {
        return this.calculateArea(heights, 0, heights.length - 1);
    }

    private int calculateArea(int[] heights, int start, int end) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            while ((stack.peek() != -1) && (heights[stack.peek()] >= heights[i])) {
                int currentHeight = heights[stack.pop()];
                int currentWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }

            stack.push(i);
        }

        while (stack.peek() != -1) {
            int currentHeight = heights[stack.pop()];
            int currentWidth = n - stack.peek() - 1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }

        return maxArea;
    }
    
    public static void main(String[] args) {
        int[] histogram = {1,2,3,4,2,10};
        LargestRectangleHistogram largestRectangleHistogram = new LargestRectangleHistogram();
        
        int area = largestRectangleHistogram.largestRectangleArea(histogram);
        System.out.println(area);
    }
}
