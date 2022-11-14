package org.pilgrim.leetcode.y2022;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    
    public TreeNode(int val) {
        this.val = val;
    }
    
    private TreeNode minValue(TreeNode node) {
        TreeNode curr = node;
        
        while(curr != null && curr.left != null) {
            curr = curr.left;
        }
        
        return curr;
    }
    
    public TreeNode insert(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        
        if(root.val > val) {
            root.left = insert(root.left, val);
        }
        else if(root.val < val) {
            root.right = insert(root.right, val);
        }
        
        return root;
    }
    
    public TreeNode delete(TreeNode root, int val) {
        if(root == null) {
            return root;
        }
        
        if(root.val > val) {
            root.left = delete(root.left, val);
        }
        else if(root.val < val) {
            root.right = delete(root.right, val);
        }
        else {
            if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }
            else {
                TreeNode node = minValue(root.right);
                root.val = node.val;
                root = delete(root.right, node.val);
            }
        }
        
        return root;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
