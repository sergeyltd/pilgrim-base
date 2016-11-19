package org.pilgrim.base;

import java.util.Stack;

import org.pilgrim.base.BSTree.Node;

public class PathSum3
{
    public int pathSum(Node root,
                       int sum)
    {
        return iterativeInorder(root, sum);
    }

    public int iterativeInorder(Node node,
                                int sum)
    {
        int count = 0;
        Stack<Integer> path = new Stack<>();
        Stack<Node> s = new Stack<>();
        while (!s.isEmpty() || node != null)
        {
            if (node != null)
            {
                path.push(node.val);
                s.push(node);
                if (node.left == null && node.right == null)
                {
                    count += calculateAllSum(path, sum);
                    path.pop();
                }
                node = node.left;
            }
            else
            {
                node = s.pop();
                //visit(node)
                node = node.right;
            }
        }
        return count;
    }

    private int calculateAllSum(Stack<Integer> path,
                                int sum)
    {
        int count = 0;
        Integer[] array = path.toArray(new Integer[0]);
        for (int i = 0; i < array.length; i++)
        {
            int s = 0;
            for (int j = i; j < array.length; j++)
            {
                s += array[j];
                if (s == sum)
                {
                    count++;
                }
            }
        }
        return count;
    }
}
