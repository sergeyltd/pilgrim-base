package org.pilgrim.base.sort;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;

public class QuickSortTest
{
    @Test
    public void test()
    {
        int[] a = { 5, 4, 2, 3, 1 };
        check(a);
    }

    @Test
    public void test1()
    {
        int[] a = { 5, 5, 5, 5, 5 };
        check(a);
    }

    @Test
    public void test2()
    {
        int[] a = { 5, 5 };
        check(a);
    }

    @Test
    public void test3()
    {
        int[] a = { 5 };
        check(a);
    }

    @Test
    public void test4()
    {
        int[] a = {};
        check(a);
    }

    @Test
    public void test5()
    {
        int[] a = { 1 };
        check(a);
    }

    @Test
    public void test6()
    {
        int lo = 10000;
        Random r = new Random(System.currentTimeMillis());
        //        for (int i = 0; i < 10000; i++) {
        int length = r.nextInt(lo) + 3;
        int[] a = new int[length];
        for (int j = 0; j < a.length; j++)
        {
            a[j] = j;
        }
        shuffleArray(a);
        check(a);
        //        }
    }

    @Test
    public void test7()
    {
        int lo = 10;
        Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < 100; i++)
        {
            int length = r.nextInt(lo) + 3;
            int[] a = new int[length];
            for (int j = 0; j < a.length; j++)
            {
                a[j] = r.nextInt(100) - 50;
            }
            shuffleArray(a);
            check(a);
        }
    }

    @Test
    public void test100()
    {
        int lo = 10;
        Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < 100; i++)
        {
            int length = r.nextInt(lo) + 3;
            int[] a = new int[length];
            for (int j = 0; j < a.length; j++)
            {
                a[j] = j;
            }
            shuffleArray(a);
            check(a);
        }
    }

    public void check(int[] a)
    {
        int[] inA = a;
        QuickSort quickSort = new QuickSort();
        quickSort.sort(a);
        System.out.print("a=");
        System.out.println(Arrays.toString(a));
        Arrays.sort(inA);
        assertEquals(inA, a);
    }

    // Implementing Fisher�Yates shuffle
    static void shuffleArray(int[] ar)
    {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}
