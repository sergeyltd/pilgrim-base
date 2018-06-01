package org.pilgrim.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find the length of the longest path where each node in
 * the path has the same value. This path may or may not pass through the root.
 * 
 * Note: The length of path between two nodes is represented by the number of
 * edges between them.
 * 
 * Example 1:
 * 
 * Input:
 * 
 * 5 / \ 4 5 / \ \ 1 1 5 Output:
 * 
 * 2 Example 2:
 * 
 * Input:
 * 
 * 1 / \ 4 5 / \ \ 4 4 5 Output:
 * 
 * 2 Note: The given binary tree has not more than 10000 nodes. The height of
 * the tree is not more than 1000.
 * 
 * @author segoncha
 *
 */
public class LongestUnivaluePath {

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        
        root.right.right = new TreeNode(5);
        
        LongestUnivaluePath longestUnivaluePath = new LongestUnivaluePath();
        int path = longestUnivaluePath.longestUnivaluePath(root);
        
        System.out.println(path);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int longestUnivaluePath(TreeNode root) {

        int maxPath = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (null == node)
                continue;

            int path = 0;
            if (null != node.left && node.val == node.left.val) {
                path += culcMaxPath(node.left) + 1;
            }
            if (null != node.right && node.val == node.right.val) {
                path += culcMaxPath(node.right) + 1;
            }

            maxPath = Math.max(maxPath, path);

            q.add(node.left);
            q.add(node.right);
        }

        return maxPath;
    }

    private int culcMaxPath(TreeNode node) {
        if (null == node)
            return 0;
        int pL = null != node && null != node.left && node.val == node.left.val ? culcMaxPath(node.left) + 1 : 0;
        int pR = null != node && null != node.right && node.val == node.right.val ? culcMaxPath(node.right) + 1 : 0;
        return Math.max(pL, pR);
    }
}
