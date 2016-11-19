package org.pilgrim.base;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class CodecDFS
{
    // Encodes a tree to a single string.
    public String serialize(TreeNode root)
    {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node,
                             StringBuilder sb)
    {
        if (node == null)
        {
            sb.append("null,");
        }
        else
        {
            sb.append(node.val + ",");
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data)
    {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes)
    {
        String val = nodes.remove();
        if (val.equals("null"))
            return null;
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }
}

// Your CodecBFS object will be instantiated and called as such:
// CodecBFS codec = new CodecBFS();
// codec.deserialize(codec.serialize(root));
