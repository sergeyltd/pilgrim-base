package org.pilgrim.leetcode.y2020.facebook;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeAvgLevelValue {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    List<Double> CalculateAvgLevelValue(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Double> res = new LinkedList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            double size = q.size();
            int sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }
            
            res.add(sum / size);
        }

        return res;
    }

    public static void main(String[] args) {
        TreeAvgLevelValue treeAvgLevelValue = new TreeAvgLevelValue();

        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(7);
        root.right = new TreeNode(9);

        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(2);

        root.right.right = new TreeNode(6);

        root.left.right.right = new TreeNode(6);
        root.left.right.right.left = new TreeNode(2);
        
        List<Double> list = treeAvgLevelValue.CalculateAvgLevelValue(root);
        
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            Double double1 = (Double) iterator.next();
            System.out.println(double1);
        }
    }
}
