package org.pilgrim.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sum3
{
    public static List<List<Integer>> threeSum(int[] a)
    {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++)
        {
            Integer val = map.get(a[i]);
            if (null == val)
            {
                val = 0;
            }
            map.put(a[i], val + 1);
        }

        Map<Integer, Integer> mapT = new HashMap<>(map);
        for (int i = 0; i < a.length; i++)
        {
            //            mapT.clear();
            //            mapT.putAll(map);

            Integer val = mapT.get(a[i]);
            if (val.intValue() <= 1)
            {
                mapT.remove(a[i]);
            }
            else
            {
                mapT.put(a[i], val - 1);
            }

            int t1 = a[i];

            for (int j = i + 1; j < a.length; j++)
            {
                if (j == i)
                {
                    continue;
                }

                int t2 = a[j];
                int t3 = -t1 - t2;

                Integer val2 = mapT.get(t2);
                if (val2.intValue() <= 1)
                {
                    mapT.remove(t2);
                }
                else
                {
                    mapT.put(t2, val2 - 1);
                }

                if (t2 != t3)
                {
                    Integer val3 = mapT.get(t3);
                    if (null != val3)
                    {
                        List<Integer> ls = new ArrayList<>();
                        list.add(ls);
                        ls.add(t1);
                        ls.add(t2);
                        ls.add(t3);
                    }
                }
                else
                {
                    Integer val3 = mapT.get(t3);
                    if (null != val3 && val3.intValue() > 1)
                    {
                        List<Integer> ls = new ArrayList<>();
                        list.add(ls);
                        ls.add(t1);
                        ls.add(t2);
                        ls.add(t3);
                    }
                }
                mapT.put(t2, val2);
            }
        }

        System.out.println(map);

        return list;
    }

    public List<List<Integer>> threeSum2(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums == null || nums.length < 3)
            return result;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++)
        {
            if (i == 0 || nums[i] > nums[i - 1])
            {
                int j = i + 1;
                int k = nums.length - 1;

                while (j < k)
                {
                    if (nums[i] + nums[j] + nums[k] == 0)
                    {
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        result.add(l);

                        j++;
                        k--;

                        //handle duplicate here
                        while (j < k && nums[j] == nums[j - 1])
                            j++;
                        while (j < k && nums[k] == nums[k + 1])
                            k--;

                    }
                    else if (nums[i] + nums[j] + nums[k] < 0)
                    {
                        j++;
                    }
                    else
                    {
                        k--;
                    }
                }
            }

        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] a = new int[] { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> threeSum = threeSum(a);

        System.out.println(threeSum);
    }
}
