package org.pilgrim.leetcode.y2022;

import org.pilgrim.leetcode.y2020.facebook.MaxPathSumBinarryTree.TreeNode;

public class ValidateBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0, null, null);
		
		ValidateBST validator = new ValidateBST();
		System.out.println(validator.isValidBST(root));

	}

	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */
	public boolean isValidBST(TreeNode root) {
		return this.isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean isValidBSTHelper(TreeNode node, long low, long high) {
		if (node == null) {
			return true;
		}

		if (node.val > low && node.val < high
				&& this.isValidBSTHelper(node.left, low, node.val)
				&& this.isValidBSTHelper(node.right, node.val, high)) {
			return true;
		}

		return false;
	}

}
