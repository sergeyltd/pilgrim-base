package org.pilgrim.leetcode.easy;
/**
Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:
Input: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
Note: The merging process must start from the root nodes of both trees.
*/


public class MergeTwoBinaryTrees {
	public TreeNode mergeTrees(TreeNode n1, TreeNode n2) {
        if(null==n1 && null==n2){
            return null;
        }
        
        if(null!=n1 && null!=n2){
            TreeNode root = new TreeNode(n1.val + n2.val);
            root.left = mergeTrees(n1.left, n2.left);
            root.right = mergeTrees(n1.right, n2.right);
            return root;
        }else if(null!=n1){
            TreeNode root = cloneTreeNode(n1);
            return root;
        }else{
            TreeNode root = cloneTreeNode(n2);
            return root;
        }
    }
    
    private TreeNode cloneTreeNode(TreeNode n){
        if(null == n){
            return null;
        }
        
        TreeNode root = new TreeNode(n.val);
        root.left = cloneTreeNode(n.left);
        root.right = cloneTreeNode(n.right);
        
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
