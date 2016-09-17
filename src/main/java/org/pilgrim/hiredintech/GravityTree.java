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
    static Map<Long, TreeNode> map = new HashMap<>();

    public static TreeNode buildTree(long[] a)
    {
        TreeNode root = null;
        for (int i = 0; i < a.length; i++)
        {
            long val = a[i];
            TreeNode treeNode = map.get(val);
            if (null == treeNode)
            {
                treeNode = new TreeNode();
                treeNode.val = val;
                map.put(val, treeNode);
            }

            long childVal = i + 2;
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
        long[] a = new long[n - 1];
        for (int i = 0; i < n - 1; i++)
        {
            a[i] = in.nextLong();
        }
        int q = in.nextInt();

        long[][] exp = new long[q][2];
        for (int i = 0; i < q; i++)
        {
            exp[i][0] = in.nextLong();
            exp[i][1] = in.nextLong();
        }

        in.close();

        TreeNode root = buildTree(a);

        for (int i = 0; i < exp.length; i++)
        {
            long u = exp[i][0];
            long v = exp[i][1];

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
        Long d1 = from.distance.get(nodeU.val);
        if (null != d1)
        {
            nodeU.distance.putIfAbsent(from.val, d1);
            return d1.longValue();
        }
        Long d2 = nodeU.distance.get(from.val);
        if (null != d2)
        {
            from.distance.putIfAbsent(nodeU.val, d1);
            return d2.longValue();
        }
        
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
        
        nodeU.distance.put(from.val, diff);
        from.distance.put(nodeU.val, diff);

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
        if (null != from && null != from.height)
        {
            return from.height.longValue();
        }
        while (null != from && null != from.parent)
        {
            from = from.parent;
            height++;
            if (null != from.height)
            {
                return from.height.longValue() + height;
            }
        }
        return height;
    }
}

class TreeNode
{
    Map<Long, Long> distance = new HashMap<>();
    List<TreeNode>  children = new ArrayList<>();
    TreeNode        parent   = null;
    long            val;
    boolean         on       = false;
    Long            height;

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
