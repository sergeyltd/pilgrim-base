package org.pilgrim.base;

import java.util.LinkedList;

public class LongestIncreasingSubsequence2
{
    static public int lengthOfLIS(int arr[])
    {
        if (null == arr)
            return 0;

        if (arr.length < 2)
            return arr.length;

        LinkedList<Integer> list = new LinkedList<>();
        for (int a : arr)
        {
            if (list.isEmpty() || list.getLast() < a)
            {
                list.add(a);
            }
            else
            {
                int i = 0;
                int j = list.size() - 1;
                while (i < j)
                {
                    int mid = (i + j) / 2;
                    if (list.get(mid) < a)
                    {
                        i = mid + 1;
                    }
                    else
                    {
                        j = mid;
                    }
                }
                list.set(j, a);
            }
        }
        return list.size();
    }
}
