package org.pilgrim.base;

import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    TreeNode        node;
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root)
    {
        this.node = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext()
    {
        return !stack.isEmpty() || null != node;
    }

    /** @return the next smallest number */
    public int next()
    {
        int res = -1;
        while (hasNext())
        {
            if (null != node)
            {
                stack.push(node);
                node = node.left;
            }
            else
            {
                node = stack.pop();
                //visit
                res = node.val;
                node = node.right;
                break;
            }
        }
        return res;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */