package org.pilgrim.base.sort;

public class QuickSort
{
    public void sort(int[] a)
    {
        if (null == a || a.length <= 0) { return; }
        sort(a, 0, a.length - 1);
    }

    private void sort(int[] a,
                      int lo,
                      int hi)
    {
        if (hi <= lo)
            return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private int partition(int[] a,
                          int lo,
                          int hi)
    {
        int i = lo;
        int j = hi + 1;
        int p = a[lo];
        while (true)
        {
            while (a[++i] < p)
            {
                if (i >= hi)
                {
                    break;
                }
            }
            while (p < a[--j])
            {
                if (j <= lo)
                {
                    break;
                }
            }

            if (i >= j)
            {
                break;
            }

            swap(a, i, j);
        }

        swap(a, lo, j);
        return j;
    }

    private void swap(int[] a,
                      int i,
                      int j)
    {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
