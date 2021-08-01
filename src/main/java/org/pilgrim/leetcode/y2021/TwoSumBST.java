package org.pilgrim.leetcode.y2021;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.pilgrim.leetcode.y2020.facebook.MaxPathSumBinarryTree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


/**
 * 
 * Given the roots of two binary search trees, root1 and root2, return true if and only if there is a node in the first tree and a node in the second tree whose values sum up to a given integer target.

 

Example 1:


Input: root1 = [2,1,4], root2 = [1,0,3], target = 5
Output: true
Explanation: 2 and 3 sum up to 5.
Example 2:


Input: root1 = [0,-10,10], root2 = [5,1,7,0,2], target = 18
Output: false
 

Constraints:

The number of nodes in each tree is in the range [1, 5000].
-109 <= Node.val, target <= 109
 *
 */
public class TwoSumBST {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if(root1 == null || root2 == null){
            return false;
        }
        
        TreeNode node1 = root1;
        Set<Integer> ySet = new HashSet<>();
        Stack<TreeNode> s = new Stack<>();
        while(!s.isEmpty() || node1 != null){
            if(node1 != null){
                s.push(node1);
                node1 = node1.left;
            }else{
                node1 = s.pop();
                ySet.add(target - node1.val);
                node1 = node1.right;
            }
        }
        
        TreeNode node2 = root2;
        s = new Stack<>();
        while(!s.isEmpty() || node2 != null){
            if(node2 != null){
                s.push(node2);
                node2 = node2.left;
            }else{
                node2 = s.pop();
                if(ySet.contains(node2.val)){
                    return true;
                }
                node2 = node2.right;
            }
        }
        
        return false;
    }
}