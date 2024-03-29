package org.pilgrim.base;

import java.util.LinkedList;
import java.util.Queue;

public class BSTree
{
    public static class Node
    {
        int  val;
        Node left, right, parent;

        Node(int d)
        {
            val = d;
            left = right = parent = null;
        }

        @Override
        public String toString()
        {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            builder.append(val);
            builder.append("]");
            return builder.toString();
        }
    }

    static Node head;

    /*
     * Given a binary search tree and a number, inserts a new node with the
     * given number in the correct place in the tree. Returns the new root
     * pointer which the caller should then use (the standard trick to avoid
     * using reference parameters).
     */
    Node insert(Node node,
                int data)
    {
        /*
         * 1. If the tree is empty, return a new, single node
         */
        if (node == null)
        {
            return (new Node(data));
        }
        else
        {

            Node temp = null;
            /* 2. Otherwise, recur down the tree */
            if (data <= node.val)
            {
                temp = insert(node.left, data);
                node.left = temp;
                temp.parent = node;
            }
            else
            {
                temp = insert(node.right, data);
                node.right = temp;
                temp.parent = node;
            }

            /* return the (unchanged) node pointer */
            return node;
        }
    }

    Node inOrderSuccessor(Node root,
                          Node n)
    {
        // step 1 of the above algorithm
        if (n.right != null) { return minValue(n.right); }

        // step 2 of the above algorithm
        Node p = n.parent;
        while (p != null && n == p.right)
        {
            n = p;
            p = p.parent;
        }
        return p;
    }

    Node inOrderSuccessor2(Node root,
                           Node n)
    {
        // step 1 of the above algorithm
        if (n.right != null) { return minValue(n.right); }

        // step 2 of the above algorithm
        Node succ = root;
        Node t = root;

        while (t != null)
        {
            if (n.val < t.val)
            {
                succ = t;
                t = t.left;
            }
            else if (n.val > t.val)
            {
                t = t.right;
            }
            else
            {
                break;
            }
        }
        return succ;
    }

    /*
     * Given a non-empty binary search tree, return the minimum val value found
     * in that tree. Note that the entire tree does not need to be searched.
     */
    Node minValue(Node node)
    {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null)
        {
            current = current.left;
        }
        return current;
    }

    public static Node findKthNode(Node node,
                                   int k)
    {
        if (k < 0) { return null; }
        int[] t = { 0 };
        Node[] an = new Node[1];
        findKthNode(node, k, t, an);
        return an[0];
    }

    private static void findKthNode(Node node,
                                    int k,
                                    int[] t,
                                    Node[] an)
    {
        if (node == null) { return; }
        if (k <= t[0]) { return; }

        findKthNode(node.left, k, t, an);
        t[0]++;
        if (k == t[0])
        {
            an[0] = node;
            return;
        }
        findKthNode(node.right, k, t, an);
    }

    public static Node findKthNodeDecending(Node node,
                                            int k)
    {
        if (k < 0) { return null; }
        int[] t = { 0 };
        Node[] an = new Node[1];
        findKthNodeDecending(node, k, t, an);
        return an[0];
    }

    private static void findKthNodeDecending(Node node,
                                             int k,
                                             int[] t,
                                             Node[] an)
    {
        if (node == null) { return; }
        if (k <= t[0]) { return; }

        findKthNodeDecending(node.right, k, t, an);
        t[0]++;
        if (k == t[0])
        {
            an[0] = node;
            return;
        }
        findKthNodeDecending(node.left, k, t, an);
    }

    public static void levelPrinter(Node node)
    {
        if (null == node) { return; }

        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty())
        {
            Queue<Node> ql = new LinkedList<>();
            while (!q.isEmpty())
            {
                Node poll = q.poll();
                System.out.print(poll);
                if (null != poll.left)
                {
                    ql.add(poll.left);
                }
                if (null != poll.right)
                {
                    ql.add(poll.right);
                }
            }
            System.out.println();
            q = ql;
        }
    }

    public static void printRightEdge(Node node)
    {
        if (null == node) { return; }

        LinkedList<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty())
        {
            LinkedList<Node> ql = new LinkedList<>();

            if (!q.isEmpty())
            {
                Node last = q.getLast();
                System.out.print(last);
            }

            while (!q.isEmpty())
            {
                Node poll = q.poll();
                if (null != poll.left)
                {
                    ql.add(poll.left);
                }
                if (null != poll.right)
                {
                    ql.add(poll.right);
                }
            }
            System.out.println();
            q = ql;
        }
    }
    
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    
    public boolean isValidBST(TreeNode root, double min, double max) {
        if (null==root)
        {
            return true;
        }
        
        if (root.val <= min || max <= root.val)
        {
            return false;
        }
        
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
    
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    
    private boolean isBalancedHeightTree = true;
    
    public boolean isBalanced(TreeNode root) {
        _maxDepth(root);
        return isBalancedHeightTree;
    }
    
    private int _maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        if(Math.abs(left-right) > 1){
            isBalancedHeightTree = false;
        }
        
        return Math.max(left, right)+1;
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
        {
            return true;
        }
        
        if(p == null)
        {
            return false;
        }
        
        if(q == null)
        {
            return false;
        }
        
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
    int diameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        __maxDepth(root);
        return diameter;
    }
    
    private int __maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        diameter = Math.max(left+right, diameter);
        
        return Math.max(left, right)+1;
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
        BSTree tree = new BSTree();
        Node root = null, temp = null, suc = null, min = null;
        root = tree.insert(root, 20);
        root = tree.insert(root, 8);
        root = tree.insert(root, 22);
        root = tree.insert(root, 4);
        root = tree.insert(root, 12);
        root = tree.insert(root, 10);
        root = tree.insert(root, 14);
        temp = root.left.right.right;
        suc = tree.inOrderSuccessor(root, temp);
        if (suc != null)
        {
            System.out.println("Inorder successor of " + temp.val + " is " + suc.val);
        }
        else
        {
            System.out.println("Inorder successor does not exist");
        }

        root = null;
        BSTree tree2 = new BSTree();
        root = tree2.insert(root, 20);
        root = tree2.insert(root, 30);
        root = tree2.insert(root, 10);
        root = tree2.insert(root, 16);
        root = tree2.insert(root, 18);
        root = tree2.insert(root, 12);
        root = tree2.insert(root, 5);
        root = tree2.insert(root, 2);

        levelPrinter(root);
        printRightEdge(root);
        
        TreeSerialization serializator = new TreeSerialization();
        
        String serializeBFS = serializator.serializeBFS(root);
        System.out.println(serializeBFS);
        
        String serialize = serializator.serialize(root);
        System.out.println(serialize);
        
        Node newRoot = serializator.deserializeBFS(serializeBFS);
        System.out.println(serializator.serializeBFS(newRoot));
    }
}
