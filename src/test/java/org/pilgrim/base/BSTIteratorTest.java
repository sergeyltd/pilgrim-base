package org.pilgrim.base;

import org.junit.Test;

public class BSTIteratorTest
{
    //
    //    @Test
    //    public void testHasNext()
    //    {
    //        fail("Not yet implemented");
    //    }

    @Test
    public void testNext()
    {
        CodecBFS codecBFS = new CodecBFS();
        TreeNode root = codecBFS.deserialize("4,2,6,1,3,5,7");
        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext())
        {
            int next = iterator.next();
            System.out.println(next);
        }
    }
}
