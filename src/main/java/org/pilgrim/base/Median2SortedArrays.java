package org.pilgrim.base;

public class Median2SortedArrays
{
    public double findMedianSortedArrays(int[] nums1,
                                         int[] nums2)
    {
        int total = nums1.length + nums2.length;
        if (total % 2 == 0)
        {
            return (findKth(total / 2 + 1, nums1, nums2, 0, 0) + findKth(total / 2, nums1, nums2, 0, 0)) / 2.0d;
        }
        else
        {
            return findKth(total / 2 + 1, nums1, nums2, 0, 0);
        }
    }

    public int findKth(int k,
                       int[] nums1,
                       int[] nums2,
                       int s1,
                       int s2)
    {
        if (s1 >= nums1.length)
            return nums2[s2 + k - 1];

        if (s2 >= nums2.length)
            return nums1[s1 + k - 1];

        if (k == 1)
            return Math.min(nums1[s1], nums2[s2]);

        int m1 = s1 + k / 2 - 1;
        int m2 = s2 + k / 2 - 1;

        int mid1 = m1 < nums1.length ? nums1[m1] : Integer.MAX_VALUE;
        int mid2 = m2 < nums2.length ? nums2[m2] : Integer.MAX_VALUE;

        if (mid1 < mid2)
        {
            return findKth(k - k / 2, nums1, nums2, m1 + 1, s2);
        }
        else
        {
            return findKth(k - k / 2, nums1, nums2, s1, m2 + 1);
        }
    }

    public double findMedian(int[] a1,
                             int[] a2)
    {
        int j = 0;
        int k = 0;
        int[] a3 = new int[a1.length + a2.length];
        for (int i = 0; i < a3.length; i++)
        {
            if (j < a1.length && k < a2.length)
            {
                int a1i = a1[j];
                int a2i = a2[k];
                if (a1i < a2i)
                {
                    a3[i] = a1i;
                    j++;
                }
                else if (a1i > a2i)
                {
                    a3[i] = a2i;
                    k++;
                }
                else
                {
                    a3[i] = a1i;
                    a3[++i] = a2i;
                    j++;
                    k++;
                }
            }
            else if (j < a1.length)
            {
                int a1i = a1[j];
                a3[i] = a1i;
                j++;
            }
            else/* if (k < a2.length)*/
            {
                int a2i = a2[k];
                a3[i] = a2i;
                k++;
            }
        }

        double m = a3[a3.length / 2];
        return m;
    }

    public static void main(String[] args)
    {
        Median2SortedArrays median2SortedArrays = new Median2SortedArrays();
        int[] a1 = new int[] { 1, 8, 9, 10, 15, 16 };
        int[] a2 = new int[] { 2, 5, 7, 9, 12, 14, 20 };
        {
            long millis = System.currentTimeMillis();
            for (int i = 0; i < 100000000; i++)
            {
                median2SortedArrays.findMedianSortedArrays(a1, a2);
            }
            System.out.println(System.currentTimeMillis() - millis);
            double m = median2SortedArrays.findMedianSortedArrays(a1, a2);
            System.out.println(m);
        }
        
        {
            long millis = System.currentTimeMillis();
            for (int i = 0; i < 100000000; i++)
            {
                median2SortedArrays.findMedian(a1, a2);
            }
            System.out.println(System.currentTimeMillis() - millis);
            double m = median2SortedArrays.findMedian(a1, a2);
            System.out.println(m);
        }
    }
}
