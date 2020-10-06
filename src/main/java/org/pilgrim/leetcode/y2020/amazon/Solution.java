package org.pilgrim.leetcode.y2020.amazon;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Solution {
    
    /*
     * expected = 3
active = 2
m = 4
[9, 4, 4, 9, 2]
     
     *
     *expected = 6
active = 5
m = 7
[3, 9, 2, 9, 5]
     *
     */

    // Complete the maximumSum function below.
    static long maximumSum(long[] a, long m) {
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
            System.out.println(max);

        }

        long max = 0;
//        {
//            long pref = 0;
//            max = 0;
//            List<Long> list = new ArrayList<Long>();
//            list.add(0l);
//
//            for (int i = 0; i < a.length; i++) {
//                pref = (pref + a[i]) % m;
//
//                max = Math.max(max, pref);
//                list.add(pref);
//            }
//            
//            
//            
//            for (long item : list) {
//                
//            }
//
//            long it = 0;
////                Long item = list.peek();
//            for (Long item : list) {
//                if (item >= pref + 1) {
//                    it = item;
//                }
//            }
//
//            if (it != 0) {
//                max = Math.max(max, pref - it + m);
//            }
//
//            list.add(pref);
//
//        }

        {
            long pref = 0;
            max = 0;
            List<Long> list = new ArrayList<Long>();
            list.add(0l);

            for (int i = 0; i < a.length; i++) {
                pref = (pref + a[i]) % m;

                max = Math.max(max, pref);

                long it = 0;
//            Long item = list.peek();
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
            
            System.out.println();
        }

        return max;

//        long max = 0;
//        int j = 0;
//        
//        List<Long> b = new LinkedList<>();
//
//        for (int i = 0; i < a.length; i++) {
//            long bi = a[i] % m;
//            //if(a[i] != 0)
//            {
//                b.add(bi);
//            }
//        }
//        
//        Collections.sort(b);
////        b = b.stream().distinct().collect(Collectors.toList());
//        
//        long min = m - b.get(0);
//        for (int i = 0; i < b.size()-1; i++) {
//            long dif = b.get(i+1) - b.get(i);
//            min = Math.min(min, dif);
//        }
//        
//        return m - min;
//
//        long s = 0;
//        for (int i = 0; i < b.size(); i++) {
//            s += b.get(i);
//            while (j < i && s >= m) {
//                s -= a[j];
//                j++;
//            }
//
//            System.out.println("========================");
//            System.out.println("m = " + m);
//            System.out.println("s = " + s);
//
//            max = (long) Math.max(max, s);  
//            System.out.println("max = " + max);
//        }
//
//        return max;
    }

    // 1802192837

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            long m = Long.parseLong(nm[1]);

            long[] a = new long[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                long aItem = Long.parseLong(aItems[i]);
                a[i] = aItem;
            }

            long result = maximumSum(a, m);
            System.out.println(result);
        }

        scanner.close();
    }
}
