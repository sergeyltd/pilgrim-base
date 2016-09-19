package org.pilgrim.hiredintech;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Solution
{
    static Map<Long, TreeNode> map = new HashMap<>();

    public static void buildTree(long[] a)
    {
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
        }
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

        buildTree(a);

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
                if (from.visited)
                {
                    continue;
                }
                from.visited = true;
                queue.addAll(from.children);

                //////////////////////////////////////////////////
                long distance = getDistance(from, nodeU);
                forces += distance * distance;
            }
            System.out.println(forces);

            map.values().forEach(item -> item.visited = false);

            ///////////////////
            nodeV.off();
        }
    }

    private static long getDistance(TreeNode from,
                                    TreeNode nodeU)
    {
        int h = 0;
        Path path1 = getPasth(from);
        Path path2 = getPasth(nodeU);
        if (path1.cycle)
        {
            int h1 = diff(path1, path2);
            int h2 = diff(path2, path1);
            h = Math.min(h1, h2);
        }
        else
        {
            Set<TreeNode> p1 = new HashSet<>(path1.path);
            Set<TreeNode> p2 = new HashSet<>(path2.path);

            p1.removeAll(path2.path);
            p2.removeAll(path1.path);
            h += p1.size();
            h += p2.size();
        }
        return h;
    }

    private static int diff(Path path1,
                            Path path2)
    {
        LinkedList<TreeNode> p1 = new LinkedList<>(path1.path);
        LinkedList<TreeNode> p2 = new LinkedList<>(path2.path);

        int nextIndex = -1;
        int h = 0;
        int size = p2.size();
        for (int i = 0; i < size; i++)
        {
            TreeNode removeLast = p2.removeLast();
            if (i == 0)
            {
                int indexOf = p1.lastIndexOf(removeLast);
                if (indexOf > -1)
                {
                    p1.remove(indexOf);
                    nextIndex = indexOf - 1;
                }
            }
            else if (nextIndex > -1)
            {
                TreeNode treeNode = p1.remove(nextIndex);
                if (treeNode == removeLast)
                {
                    nextIndex--;
                }
                else
                {
                    h = p2.size() + 1 + nextIndex + 1;
                    break;
                }
            }
            else
            {
                h = p2.size() + 1;
                break;
            }
        }
        return h;
    }

    private static Path getPasth(TreeNode from)
    {
        Path path = new Path();
        path.add(from);
        while (null != from && null != from.parent)
        {
            from = from.parent;
            if (path.contains(from))
            {
                path.cycle = true;
                break;
            }
            path.add(from);
        }
        return path;
    }
}

class Path
{
    boolean       cycle = false;
    Set<TreeNode> path  = new LinkedHashSet<>();

    public void add(TreeNode node)
    {
        path.add(node);
    }

    public boolean contains(TreeNode node)
    {
        return path.contains(node);
    }
}

class TreeNode
{
    List<TreeNode> children = new ArrayList<>();
    TreeNode       parent   = null;
    long           val;
    boolean        on       = false;
    boolean        visited  = false;
    //    Long           height;

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

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("TreeNode [val=");
        builder.append(val);
        builder.append("]");
        return builder.toString();
    }

}