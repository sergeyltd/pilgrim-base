package org.pilgrim.base;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class LongestIncreasingSubsequence2Test
{
    static int[] data = null;

    @BeforeClass
    static public void prepareData()
    {
        Random rnd = new Random(System.currentTimeMillis());
        data = new int[100000];
        for (int i = 0; i < data.length; i++)
        {
            data[i] = rnd.nextInt(1000000);
        }
    }

    @Test
    public void testLengthOfLIS()
    {
        int[] arr = { 5, 6, 2, 7, 3, 4, 5, 1, 0, 9 };
        int max = LongestIncreasingSubsequence2.lengthOfLIS(arr);
        assertEquals(5, max);
    }

    @Test
    public void testLengthOfLIS2()
    {
        int[] arr = {};
        int max = LongestIncreasingSubsequence2.lengthOfLIS(arr);
        assertEquals(0, max);
    }

    @Test
    public void testLengthOfLIS3()
    {
        int[] arr = null;
        int max = LongestIncreasingSubsequence2.lengthOfLIS(arr);
        assertEquals(0, max);
    }

    @Test
    public void testLengthOfLIS4()
    {
        int[] arr = { 5 };
        int max = LongestIncreasingSubsequence2.lengthOfLIS(arr);
        assertEquals(1, max);
    }

    @Test
    public void testLengthOfLIS5()
    {
        int[] arr = { 5, 6 };
        int max = LongestIncreasingSubsequence2.lengthOfLIS(arr);
        assertEquals(2, max);
    }

    @Test
    public void testLengthOfLIS6()
    {
        int[] arr = { 6, 2 };
        int max = LongestIncreasingSubsequence2.lengthOfLIS(arr);
        assertEquals(1, max);
    }

    @Test
    public void testLengthOfLIS7()
    {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int max = LongestIncreasingSubsequence2.lengthOfLIS(arr);
        assertEquals(9, max);
    }

    @Test
    public void testLengthOfLIS8()
    {
        int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int max = LongestIncreasingSubsequence2.lengthOfLIS(arr);
        assertEquals(1, max);
    }

    @Test
    @Ignore
    public void testLengthOfLIS9()
    {
        int max1 = LongestIncreasingSubsequence.lengthOfLIS(data);
        int max2 = LongestIncreasingSubsequence2.lengthOfLIS(data);
        assertEquals(max1, max2);
    }

    @Test(timeout = 300)
    public void testLengthOfLIS10()
    {
        LongestIncreasingSubsequence2.lengthOfLIS(data);
    }

    @Test
    public void testLengthOfLIS11()
    {
        int[] arr = { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE };
        int max = LongestIncreasingSubsequence2.lengthOfLIS(arr);
        assertEquals(1, max);
    }

    @Test
    public void testLengthOfLIS12()
    {
        int[] arr = { Integer.MAX_VALUE, 1, 2, 3, Integer.MAX_VALUE };
        int max = LongestIncreasingSubsequence2.lengthOfLIS(arr);
        assertEquals(4, max);
    }

    @Test
    public void testLengthOfLIS13()
    {
        int[] arr = { Integer.MIN_VALUE, 1, 2, 3, Integer.MAX_VALUE };
        int max = LongestIncreasingSubsequence2.lengthOfLIS(arr);
        assertEquals(5, max);
    }

    @Test
    public void testLengthOfLIS14()
    {
        int[] arr = { Integer.MAX_VALUE, Integer.MIN_VALUE, 2, 5 };
        int max = LongestIncreasingSubsequence2.lengthOfLIS(arr);
        assertEquals(3, max);
    }

    @Test
    public void testLengthOfLIS15()
    {
        int[] arr = { Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE };
        int max = LongestIncreasingSubsequence2.lengthOfLIS(arr);
        assertEquals(1, max);
    }

    @Test
    public void testLengthOfLIS16()
    {
        int[] arr = { 0, 0, 0, 0, 0, 0, 0 };
        int max = LongestIncreasingSubsequence2.lengthOfLIS(arr);
        assertEquals(1, max);
    }
}
