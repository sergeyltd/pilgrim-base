package org.pilgrim.leetcode.y2020.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ZT {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Random rnd = new Random();
        while (true) {
            long m = rnd.nextInt(20);
            long[] a = new long[5];
            for (int i = 0; i < a.length; i++) {
                a[i] = rnd.nextInt(30);
            }

            long expected = maximumSumWork(a, m);
//            long active = maximumSumTry(a, m);
            long active2 = maximumSumTry2(a, m);

            System.out.println("*********************");
            System.out.println("expected = " + expected);
//            System.out.println("active = " + active);
            System.out.println("active2 = " + active2);
            System.out.println("m = " + m);
            System.out.println(Arrays.toString(a));

            if (expected != active2) {

                break;
            }
        }

    }

    // Complete the maximumSum function below.
    static long maximumSumWork(long[] a, long m) {
        if (a == null || a.length <= 1 || a.length > 100000 || m < 1 || m > 100000000000000l) {
            return 0;
        }

        {
            int n = a.length;
            long max = 0;

            for (int i = 0; i < n; i++) {
                long sum = a[i];
                max = Math.max(sum % m, max);
                if (max == m - 1)
                    break;
                for (int j = i + 1; j < n; j++) {
                    sum += a[j];
                    max = Math.max(sum % m, max);
                    if (max == m - 1)
                        break;
                }
            }
//            System.out.println(max);

            return max;

        }
    }

    // Complete the maximumSum function below.
    static long maximumSumTry(long[] a, long m) {
        if (a == null || a.length <= 1 || a.length > 100000 || m < 1 || m > 100000000000000l) {
            return 0;
        }
        long max = 0;
        {
            long pref = 0;
            max = 0;
            List<Long> list = new ArrayList<Long>();
            list.add(0l);

            for (int i = 0; i < a.length; i++) {
                pref = (pref + a[i]) % m;

                max = Math.max(max, pref);

                long it = 0;
                for (Long item : list) {
                    if (item >= pref + 1) {
                        it = item;
                    }
                }

                if (it != 0) {
                    max = Math.max(max, pref - it + m);
                }

                list.add(pref);

            }

            // list.remove(0);

            System.out.println();
            System.out.println("prefs = " + Arrays.toString(list.toArray()));

            list = list.stream().distinct().collect(Collectors.toList());

            Collections.sort(list);
            System.out.println("prefs = " + Arrays.toString(list.toArray()));

            long min = Long.MAX_VALUE;
            for (int i = 0; i < list.size() - 1; i++) {
                long s1 = list.get(i);
                long s2 = list.get(i + 1);
                min = Math.min(min, Math.abs(s1 - s2));

                System.out.println("min = " + min);
            }

            max = m - min;

        }

        return max;
    }

    static long maximumSumTry2(long[] a, long m) {
        if (a == null || a.length <= 1 || a.length > 100000 || m < 1 || m > 100000000000000l) {
            return 0;
        }
        
        long sum[] = new long[a.length];
        sum[0] = a[0] % m;
        TreeMap<Long, Long> tree = new TreeMap<Long, Long>();
        tree.put(sum[0], sum[0]);
        long res = sum[0];

        for (int i = 1; i < a.length; i++) {
            sum[i] = sum[i - 1] + a[i];
            sum[i] %= m;

            Long min = tree.ceilingKey(sum[i] + 1);
            if(min == null) {
                min = 0l;
            }
            res = Math.max((sum[i] - min + m) % m, res);
            tree.put(sum[i], sum[i]);
        }

        return res;
    }

}
