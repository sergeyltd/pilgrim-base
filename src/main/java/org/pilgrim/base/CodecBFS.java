package org.pilgrim.base;

import java.util.LinkedList;
import java.util.Queue;

//Definition for a binary tree node.
class TreeNode
{
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x)
    {
        val = x;
    }
}

public class CodecBFS
{
    // Encodes a tree to a single string.
    public String serialize(TreeNode root)
    {
        if (null == root)
            return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int lastD = 0;
        while (!q.isEmpty())
        {
            Queue<TreeNode> qt = new LinkedList<>();
            while (!q.isEmpty())
            {
                TreeNode poll = q.poll();
                if (null == poll)
                {
                    sb.append("null").append(",");
                    continue;
                }
                sb.append(poll.val).append(",");
                lastD = sb.length();
                /*if (null == poll.left && null == poll.right)
                {
                    continue;
                }*/
                qt.add(poll.left);
                qt.add(poll.right);
            }
            q = qt;
        }
        sb.delete(lastD, sb.length());
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data)
    {
        TreeNode root = null;
        if (null == data || data.isEmpty()) { return root; }
        String[] s = data.split(",", 0);
        root = new TreeNode(Integer.parseInt(s[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int c = 1;
        while (!q.isEmpty() && c < s.length)
        {
            TreeNode p = q.poll();
            if (!s[c].equals("null"))
            {
                p.left = new TreeNode(Integer.parseInt(s[c]));
                q.add(p.left);
            }
            c++;
            if (c >= s.length)
            {
                break;
            }
            if (!s[c].equals("null"))
            {
                p.right = new TreeNode(Integer.parseInt(s[c]));
                q.add(p.right);
            }
            c++;
        }
        return root;
    }
    
    public String serializeI(TreeNode root) {
        String output = null;
        if (root != null) {
            String val;
            StringBuffer buffer  = new StringBuffer();
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                if (node ==null) {
                    val = "null";
                } else {
                    val = String.valueOf(node.val);
                    q.add(node.left);
                    q.add(node.right);
                }
                buffer.append(val);
                if (!q.isEmpty())
                    buffer.append(",");
            }
            output=buffer.toString();
        }

        return output;

    }

    public static void main(String[] args)
    {
        CodecBFS codecBFS = new CodecBFS();
        TreeNode root = codecBFS.deserialize("1,-1,2,null,null,3");
        String serialize = codecBFS.serialize(root);
        System.out.println(serialize);
        
        String serializeI = codecBFS.serializeI(root);
        System.out.println(serializeI);
    }
}

// Your CodecBFS object will be instantiated and called as such:
// CodecBFS codec = new CodecBFS();
// codec.deserialize(codec.serialize(root));