class Solution {
    public int calculateArea(int[] heights, int start, int end) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int n = heights.length;
        int maxArea = 0;
        
        for (int i = 0; i < n; i++) {
            while ((stack.peek() != -1)
                    && (heights[stack.peek()] >= heights[i])) {
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
}
