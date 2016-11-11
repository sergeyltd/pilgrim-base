package org.pilgrim.base;

public class RotatedSortedArray
{
    public int findMidium(int[] a)
    {
        int i = 0;
        int j = a.length - 1;

        while (i <= j)
        {
            // handle cases like [3, 1, 2, 3]
            while (i != j || a[i] == a[j])
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

    public int findMin(int[] a)
    {
        int i = 0;
        int j = a.length - 1;

        while (i <= j)
        {
            // handle cases like [3, 1, 2, 3]
            while (i != j || a[i] == a[j])
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
