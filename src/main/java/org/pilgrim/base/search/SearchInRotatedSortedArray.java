package org.pilgrim.base.search;

public class SearchInRotatedSortedArray
{
    public int search(int[] a,
                      int target)
    {
        int i = 0;
        int j = a.length - 1;

        while (i <= j)
        {
            int mid = (j + i) / 2;
            if (target == a[mid])
                return mid;

            if (a[i] <= a[mid])
            {
                if (a[i] <= target && target < a[mid])
                {
                    j = mid - 1;
                }
                else
                {
                    i = mid + 1;
                }
            }
            else
            {
                if (a[mid] < target && target <= a[j])
                {
                    i = mid + 1;
                }
                else
                {
                    j = mid - 1;
                }
            }
        }

        return -1;
    }
}
