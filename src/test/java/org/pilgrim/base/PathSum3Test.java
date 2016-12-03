package org.pilgrim.base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.pilgrim.base.BSTree.Node;

public class PathSum3Test
{

    @Test
    public void testPathSum()
    {
        TreeSerialization treeSerialization = new TreeSerialization();
        Node root = treeSerialization.deserialize("10,5,3,3,#,#,2,#,#,2,#,#,1,#,#,-3,#,11,#,#");
        System.out.println(root);

        PathSum3 pathSum3 = new PathSum3();
        int pathSum = pathSum3.pathSum(root, 8);
        System.out.println(pathSum);
        assertEquals(3, pathSum);
    }
}
