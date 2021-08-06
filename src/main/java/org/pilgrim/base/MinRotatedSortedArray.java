package org.pilgrim.base;

public class MinRotatedSortedArray
{
    public int findMin(int[] a)
    {
        int i = 0;
        int j = a.length - 1;

        while (i <= j)
        {
            // handle cases like [3, 1, 2, 3]
            while (i < j && a[i] == a[j])
            {
                i++;
            }

            if (a[i] <= a[j]) { return a[i]; }

            int m = (i + j) / 2;
            if (a[m] >= a[i])
            {
                i = m + 1;
            }
            else
            {
                j = m;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        MinRotatedSortedArray mrsa = new MinRotatedSortedArray();
        System.out.println(mrsa.findMin(new int[] {4,9,0,2,3}));
    }
}
