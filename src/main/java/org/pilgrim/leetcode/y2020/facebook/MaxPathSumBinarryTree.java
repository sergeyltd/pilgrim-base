package org.pilgrim.leetcode.y2020.facebook;

public class MaxPathSumBinarryTree {
    
    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode(){}
        TreeNode(int val) {this.val = val;}
    }
    
    int maxSum = Integer.MIN_VALUE;
    
    public int getMaxSumTreePath(TreeNode node) {
        maxSumHelper(node);
        
        return maxSum;
    }
    
    private int maxSumHelper(TreeNode node) {
        if(node == null) {
            return 0;
        }
        
        int leftMax = Math.max(maxSumHelper(node.left), 0);
        int rightMax = Math.max(maxSumHelper(node.right), 0);
        
        int newMax = node.val + leftMax + rightMax;
        maxSum = Math.max(newMax, maxSum);
        
        return node.val + Math.max(leftMax, rightMax);
        
    }

    public static void main(String[] args) {

    }

}
