package org.pilgrim.leetcode.tree;

public class Toolbox {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    private int answer; // don't forget to initialize answer before call maximum_depth

    public void maximum_depth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            answer = Math.max(answer, depth);
        }
        maximum_depth(root.left, depth + 1);
        maximum_depth(root.right, depth + 1);
    }
}
