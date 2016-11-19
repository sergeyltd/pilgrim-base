package org.pilgrim.base;

import java.util.LinkedList;
import java.util.Stack;

import org.pilgrim.base.BSTree.Node;

public class TreeSerialization
{
    public String serializeBFS(Node root)
    {
        if (root == null) { return ""; }

        StringBuilder sb = new StringBuilder();

        LinkedList<Node> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty())
        {
            Node t = queue.poll();
            if (t != null)
            {
                sb.append(String.valueOf(t.val) + ",");
                queue.add(t.left);
                queue.add(t.right);
            }
            else
            {
                sb.append("#,");
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
        return sb.toString();
    }

    public Node deserializeBFS(String data)
    {
        if (data == null || data.length() == 0)
            return null;

        String[] arr = data.split(",", 0);
        Node root = new Node(Integer.parseInt(arr[0]));

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty())
        {
            Node t = queue.poll();

            if (t == null)
                continue;

            if (!arr[i].equals("#"))
            {
                t.left = new Node(Integer.parseInt(arr[i]));
                queue.offer(t.left);

            }
            else
            {
                t.left = null;
                queue.offer(null);
            }
            i++;

            if (!arr[i].equals("#"))
            {
                t.right = new Node(Integer.parseInt(arr[i]));
                queue.offer(t.right);

            }
            else
            {
                t.right = null;
                queue.offer(null);
            }
            i++;
        }

        return root;
    }

    // Encodes a tree to a single string.
    public String serialize(Node root)
    {
        if (root == null)
            return null;

        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty())
        {
            Node h = stack.pop();
            if (h != null)
            {
                sb.append(h.val + ",");
                stack.push(h.right);
                stack.push(h.left);
            }
            else
            {
                sb.append("#,");
            }
        }

        return sb.toString().substring(0, sb.length() - 1);
    }

    // Decodes your encoded val to tree.
    public Node deserialize(String data)
    {
        if (data == null)
            return null;

        int[] t = { 0 };
        String[] arr = data.split(",");

        return helper(arr, t);
    }

    public Node helper(String[] arr,
                           int[] t)
    {
        if (arr[t[0]].equals("#")) { return null; }

        Node root = new Node(Integer.parseInt(arr[t[0]]));

        t[0] = t[0] + 1;
        root.left = helper(arr, t);
        t[0] = t[0] + 1;
        root.right = helper(arr, t);

        return root;
    }
}
//
//class TreeNode
//{
//    public int      val;
//    public TreeNode right;
//    public TreeNode left;
//
//    public TreeNode(int val)
//    {
//        this.val = val;
//    }
//
//    @Override
//    public String toString()
//    {
//        StringBuilder builder = new StringBuilder();
//        builder.append("[val=");
//        builder.append(val);
//        builder.append("]");
//        return builder.toString();
//    }
//}
