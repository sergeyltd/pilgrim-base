package org.pilgrim.base;

public class MinRotatedSortedArray
{
    public int findMin(int[] a)
    {
        int i = 0;
        int j = a.length - 1;

        while (i <= j)
        {
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

        //		int i = 0;
        //		int j = nums.length - 1;
        //
        //		while (i <= j) {
        //
        //			// handle cases like [3, 1, 3]
        //			while (nums[i] == nums[j] && i != j) {
        //				i++;
        //			}
        //
        //			if (nums[i] <= nums[j]) {
        //				return nums[i];
        //			}
        //
        //			int m = (i + j) / 2;
        //			if (nums[m] >= nums[i]) {
        //				i = m + 1;
        //			} else {
        //				j = m;
        //			}
        //		}
        //		return -1;
    }
}
