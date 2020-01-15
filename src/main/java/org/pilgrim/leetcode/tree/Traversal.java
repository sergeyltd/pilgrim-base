package org.pilgrim.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Traversal {
    public List<Integer> preorderTraversal_It(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        if (null == root) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);

            if (null != node.right) {
                stack.push(node.right);
            }
            if (null != node.left) {
                stack.push(node.left);
            }
        }

        return res;
    }
    
    public void preorderTraversal_Rec(TreeNode root, List<Integer> res) {
        if(null == root)
        {
            return;
        }
        
        res.add(root.val);
        preorderTraversal_Rec(root.left, res);
        preorderTraversal_Rec(root.right, res);
    }
    
    public List<Integer> inorderTraversal_It(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        
        if(null == root){
            return res;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.isEmpty() || null != root){
         if(null != root){
             stack.push(root);
             root = root.left;
         }else{
             root = stack.pop();
             res.add(root.val);
             root = root.right;
         }
        }
        
        return res;
    }
    
    public void inorderTraversal_Rec(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        
        inorderTraversal_Rec(root.left, res);
        res.add(root.val);
        inorderTraversal_Rec(root.right, res);
    }
    
    public List<Integer> postorderTraversal_It(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        
        if(null == root){
            return res;
        }
        
        TreeNode lastNodeVisited = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.isEmpty() || null != root){
            if(null != root)
            {
                stack.push(root);
                root = root.left;
            }
            else{
                TreeNode peekNode = stack.peek();
                if(peekNode.right != null && peekNode.right != lastNodeVisited){
                    root = peekNode.right;
                }
                else{
                    res.add(peekNode.val);
                    lastNodeVisited = stack.pop();
                }
            }
        }
        
        return res;
    }
    
    public void postorderTraversal_Rec(TreeNode root, List<Integer> res) {
        if(null == root){
            return;
        }
        
        postorderTraversal_Rec(root.left, res);
        postorderTraversal_Rec(root.right, res);
        res.add(root.val);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(null == root){
            return list;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            Queue<TreeNode> q2 = new LinkedList<>();
            List<Integer> list2 = new ArrayList<>();
            while(!q.isEmpty()){
                TreeNode node = q.poll();
                list2.add(node.val);
                if (null != node.left){
                    q2.add(node.left);
                }
                if (null != node.right){
                    q2.add(node.right);
                }
            }
            list.add(list2);
            q = q2;
        }
        
        return list;
    }
    
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.offer(root);
        }
        TreeNode cur;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> subAns = new LinkedList<Integer>();
            for (int i = 0; i < size; ++i) {        // traverse nodes in the same level
                cur = q.poll();
                subAns.add(cur.val);                // visit the root
                if (cur.left != null) {
                    q.offer(cur.left);              // push left child to queue if it is not null
                }
                if (cur.right != null) {
                    q.offer(cur.right);             // push right child to queue if it is not null
                }
            }
            ans.add(subAns);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        
    }
}