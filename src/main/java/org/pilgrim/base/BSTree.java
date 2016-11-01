package org.pilgrim.base;

public class BSTree
{
    class Node
    {
        int  data;
        Node left, right, parent;

        Node(int d)
        {
            data = d;
            left = right = parent = null;
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
            if (data <= node.data)
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
            if (n.data < t.data)
            {
                succ = t;
                t = t.left;
            }
            else if (n.data > t.data)
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
     * Given a non-empty binary search tree, return the minimum data value found
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
            System.out.println("Inorder successor of " + temp.data + " is " + suc.data);
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

    }
}
