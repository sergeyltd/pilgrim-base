package org.pilgrim.base;

import java.util.LinkedHashSet;
import java.util.Set;

public class StringPermutation
{
    private Set<String> list = new LinkedHashSet<>();
    
    public void permutation(String str)
    {
        permutation("", str);
        System.out.println("-----------------------------------------------");
        list.forEach(System.out::println);
    }

    private void permutation(String pref,
                                   String str)
    {
        int n = str.length();
        if (n == 0)
        {
            System.out.println(pref);
            list.add(pref);
        }
        else
        {
            for (int i = 0; i < n; i++)
            {
                permutation(pref + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
            }
        }
    }
}
