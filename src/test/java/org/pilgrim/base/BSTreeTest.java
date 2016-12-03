package org.pilgrim.base;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.pilgrim.base.BSTree.Node;

public class BSTreeTest
{
    private static Node root;

    @BeforeClass
    public static void init()
    {
        root = null;
        BSTree tree = new BSTree();
        root = tree.insert(root, 2); //1
        root = tree.insert(root, 5); //2
        root = tree.insert(root, 10);//3
        root = tree.insert(root, 12);//4
        root = tree.insert(root, 16);//5
        root = tree.insert(root, 18);//6
        root = tree.insert(root, 20);//7
        root = tree.insert(root, 30);//8
    }

    @Test
    public void testFindKthNode1()
    {
        Node node = BSTree.findKthNode(root, 1);
        assertEquals(2, node.val);
    }

    @Test
    public void testFindKthNode2()
    {
        Node node = BSTree.findKthNode(root, 2);
        assertEquals(5, node.val);
    }

    @Test
    public void testFindKthNode3()
    {
        Node node = BSTree.findKthNode(root, 3);
        assertEquals(10, node.val);
    }

    @Test
    public void testFindKthNode4()
    {
        Node node = BSTree.findKthNode(root, 4);
        assertEquals(12, node.val);
    }

    @Test
    public void testFindKthNode5()
    {
        Node node = BSTree.findKthNode(root, 5);
        assertEquals(16, node.val);
    }

    @Test
    public void testFindKthNode6()
    {
        Node node = BSTree.findKthNode(root, 6);
        assertEquals(18, node.val);
    }

    @Test
    public void testFindKthNode7()
    {
        Node node = BSTree.findKthNode(root, 7);
        assertEquals(20, node.val);
    }

    @Test
    public void testFindKthNode8()
    {
        Node node = BSTree.findKthNode(root, 8);
        assertEquals(30, node.val);
    }

    //////////////////////////////////////////////////////////////////
    @Test
    public void testFindKthNodeDecending1()
    {
        Node node = BSTree.findKthNodeDecending(root, 1);
        assertEquals(30, node.val);
    }

    @Test
    public void testFindKthNodeDecending2()
    {
        Node node = BSTree.findKthNodeDecending(root, 2);
        assertEquals(20, node.val);
    }

    @Test
    public void testFindKthNodeDecending3()
    {
        Node node = BSTree.findKthNodeDecending(root, 3);
        assertEquals(18, node.val);
    }

    @Test
    public void testFindKthNodeDecending4()
    {
        Node node = BSTree.findKthNodeDecending(root, 4);
        assertEquals(16, node.val);
    }

    @Test
    public void testFindKthNodeDecending5()
    {
        Node node = BSTree.findKthNodeDecending(root, 5);
        assertEquals(12, node.val);
    }

    @Test
    public void testFindKthNodeDecending6()
    {
        Node node = BSTree.findKthNodeDecending(root, 6);
        assertEquals(10, node.val);
    }

    @Test
    public void testFindKthNodeDecending7()
    {
        Node node = BSTree.findKthNodeDecending(root, 7);
        assertEquals(5, node.val);
    }

    @Test
    public void testFindKthNodeDecending8()
    {
        Node node = BSTree.findKthNodeDecending(root, 8);
        assertEquals(2, node.val);
    }
}
