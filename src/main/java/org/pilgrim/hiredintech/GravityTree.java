package org.pilgrim.hiredintech;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class GravityTree
{
    static Map<Integer, TreeNode> map = new HashMap<>();

    public static TreeNode buildTree(int[] a)
    {
        TreeNode root = null;
        for (int i = 0; i < a.length; i++)
        {
            int val = a[i];
            TreeNode treeNode = map.get(val);
            if (null == treeNode)
            {
                treeNode = new TreeNode();
                treeNode.val = val;
                map.put(val, treeNode);
            }

            int childVal = i + 2;
            TreeNode treeChild = map.get(childVal);
            if (null == treeChild)
            {
                treeChild = new TreeNode();
                treeChild.val = childVal;
                map.put(childVal, treeChild);
            }
            if (null != treeNode)
            {
                treeNode.add(treeChild);
            }

            root = treeNode;
        }

        while (null != root && null != root.parent)
        {
            root = root.parent;
        }
        return root;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n - 1];
        for (int i = 0; i < n - 1; i++)
        {
            a[i] = in.nextInt();
        }
        int q = in.nextInt();

        int[][] exp = new int[q][2];
        for (int i = 0; i < q; i++)
        {
            exp[i][0] = in.nextInt();
            exp[i][1] = in.nextInt();
        }

        in.close();

        TreeNode root = buildTree(a);

        for (int i = 0; i < exp.length; i++)
        {
            int u = exp[i][0];
            int v = exp[i][1];

            long forces = 0;

            TreeNode nodeV = map.get(v);
            TreeNode nodeU = map.get(u);
            nodeV.on();
            ///////////////////
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(nodeV);
            while (!queue.isEmpty())
            {
                TreeNode from = queue.poll();
                queue.addAll(from.children);

                //////////////////////////////////////////////////
                long distance = getDistance(from, nodeU);
                forces += distance * distance;
            }
            System.out.println(forces);

            ///////////////////
            nodeV.off();
        }
    }

    private static long getDistance(TreeNode from,
                                    TreeNode nodeU)
    {
        long height1 = getHeight(from);
        long height2 = getHeight(nodeU);

        long diff = height1 - height2;
        if (diff < 0)
        {
            diff = Math.abs(diff);
            nodeU = rise(nodeU, diff);
        }
        else if (diff > 0)
        {
            diff = Math.abs(diff);
            from = rise(from, diff);
        }
        diff = Math.abs(diff);

        while (from != nodeU)
        {
            from = from.parent;
            nodeU = nodeU.parent;
            diff += 2;
        }

        return diff;
    }

    private static TreeNode rise(TreeNode from,
                                 long diff)
    {
        for (int i = 0; i < diff; i++)
        {
            from = from.parent;
        }
        return from;
    }

    private static long getHeight(TreeNode from)
    {
        long height = 0;
        while (null != from && null != from.parent)
        {
            from = from.parent;
            height++;
        }
        return height;
    }
}

class TreeNode
{
    List<TreeNode> children = new ArrayList<>();
    TreeNode       parent   = null;
    long           val;
    boolean        on       = false;

    public boolean isOn()
    {
        return on;
    }

    public void on()
    {
        this.on = true;
    }

    public void off()
    {
        this.on = false;
    }

    public TreeNode add(TreeNode treeNode)
    {
        children.add(treeNode);
        treeNode.parent = this;
        return this;
    }
}
