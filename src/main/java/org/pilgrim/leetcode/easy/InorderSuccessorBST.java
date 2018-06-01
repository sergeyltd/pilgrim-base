package org.pilgrim.leetcode.easy;

import java.util.Stack;

/**
 * Inorder Successor in BST Given a binary search tree and a node in it, find
 * the in-order successor of that node in the BST.
 * 
 * Note: If the given node has no in-order successor in the tree, return null.
 * 
 * Example 1:
 * 
 * Input: root = [2,1,3], p = 1
 * 
 * 2 / \ 1 3
 * 
 * Output: 2 Example 2:
 * 
 * Input: root = [5,3,6,2,4,null,null,1], p = 6
 * 
 * 5 / \ 3 6 / \ 2 4 / 1
 * 
 * Output: null
 * 
 * @author segoncha
 *
 */

public class InorderSuccessorBST {

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode
     * left; TreeNode right; TreeNode(int x) { val = x; } }
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        boolean found = false;
        Stack<TreeNode> s = new Stack<>();
        while (!s.isEmpty() || root != null) {
            if (root != null) {
                s.push(root);
                root = root.left;
            } else {
                root = s.pop();
                // visit(node)
                System.out.println(root.val);
                if (found) {
                    succ = root;
                    break;
                }
                if (p.val == root.val) {
                    found = true;
                }
                root = root.right;
            }
        }

        return succ;
    }

    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        if (root == null) return null;

        TreeNode next = null;
        TreeNode c = root;
        while (c != null && c.val != p.val) {
            if (c.val > p.val) {
                next = c;
                c = c.left;
            } else {
                c = c.right;
            }
        }

        if (c == null) return null;

        if (c.right == null) return next;

        c = c.right;
        while (c.left != null)
            c = c.left;

        return c;
    }
}