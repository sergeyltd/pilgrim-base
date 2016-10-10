package org.pilgrim.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sun.awt.resources.awt;

public class Sum2 {
	public static List<List<Integer>> threeSum2(int[] a, int t) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (a == null || a.length < 2)
			return result;

		Arrays.sort(a);

		// for (int i = 0; i < a.length - 1; i++)
		{
			// if (i == 0 || a[i] > a[i - 1])
			{
				int j = 0;
				int k = a.length - 1;

				while (j < k) {
					if (a[j] + a[k] == t) {
						List<Integer> l = new ArrayList<Integer>();
						l.add(a[j]);
						l.add(a[k]);
						result.add(l);

						j++;
						k--;

						// handle duplicate here
						while (j < k && a[j] == a[j - 1])
							j++;
						while (j < k && a[k] == a[k + 1])
							k--;

					} else if (a[j] + a[k] < t) {
						j++;
					} else {
						k--;
					}
				}
			}

		}

		return result;
	}
	
	public static List<List<Integer>> threeSum3(int[] a, int t)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (a == null || a.length < 3)
            return result;

        Arrays.sort(a);

        for (int i = 0; i < a.length - 2; i++)
        {
            if (i == 0 || a[i] > a[i - 1])
            {
                int j = i + 1;
                int k = a.length - 1;

                while (j < k)
                {
                    if (a[i] + a[j] + a[k] == t)
                    {
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(a[i]);
                        l.add(a[j]);
                        l.add(a[k]);
                        result.add(l);

                        j++;
                        k--;

                        //handle duplicate here
                        while (j < k && a[j] == a[j - 1])
                            j++;
                        while (j < k && a[k] == a[k + 1])
                            k--;

                    }
                    else if (a[i] + a[j] + a[k] < t)
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

	public static void main(String[] args) {
		int[] a = new int[] { 15,16,20,22,28,40 };
		System.out.println(threeSum2(a, 37));
		System.out.println(threeSum2(a, 55));
		System.out.println(threeSum2(a, 68));
		System.out.println(threeSum2(a, 43));
		System.out.println(threeSum3(a, 82));
		System.out.println(threeSum3(a, 65));
	}
}
