package org.pilgrim.leetcode.y2020.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Temp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        {
//            int am = hackerlandRadioTransmitters(new int[] { 7, 2, 4, 6, 5, 9, 12, 11 }, 2);
//            System.out.println(am);
//        }
//        {
//            int am = hackerlandRadioTransmitters(new int[] { 1, 2, 3, 4, 5 }, 1);
//            System.out.println(am);
//        }
//        {
//            int am = hackerlandRadioTransmitters(new int[] { 1, 5, 4, 2, 6, 15, 12 }, 2);
//            System.out.println(am);
//        }
        {
            int[] am = icecreamParlor(4, new int[] { 1, 4, 5, 3, 2 });
            System.out.println(am[0] +", " +am[1]);
        }
        
        
    }
    
 // Complete the maximumSum function below.
    static long maximumSumMod(long[] a, long m) {
        if(a==null || a.length <= 1 || a.length > 100000 || m < 1 || m > 100000000000000l){
            return 0;
        }

        long max = 0;
        int j = 0;

        for(int i=0; i<a.length; i++){
            a[i] = a[i]%m;
        }

        long s = 0;
        for(int i=0; i<a.length; i++){
            s += a[i];
            while(j<i && s >= m){
                s -= a[j];
                j++;
            }

            max = Math.max(max, s);
        }

        return max;
    }
    
 // Complete the balancedSums function below.
    static String balancedSums(List<Integer> arr) {
        if(arr == null || arr.isEmpty() || arr.size() > 100000){
            return "NO";
        }

        boolean res = false;

        long sum = 0;
        for (Integer a : arr) {
            sum += a;
        }
        
        long sL = 0;
        long sR = sum;
        int m = 0;
        
        for (int i = 0; i < arr.size() && !res; i++) {
            
            sL += m;
            
            int a = arr.get(i);
            m = a;
            sR = sR - m;
            
            if(sL == sR) {
                res = true;
            }
            
        }

        return res ? "YES" : "NO";
    }
    
    // Complete the icecreamParlor function below.
    static int[] icecreamParlor(int m, int[] arr) {
        if(m < 2 || m > 10000 || arr == null || arr.length <= 0 || arr.length > 10000){
            System.out.println("Error");
            return null;
        }

        int[] res = new int[2];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                map.get(arr[i]).add(i+1);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i+1);
                map.put(arr[i], list);
            }
        }

        for(int a : arr){
            int r = m - a;
            if(r > 0 && map.containsKey(a) && map.containsKey(r)){
                List<Integer> aI = map.get(a);
                if(a == r && aI.size() > 1){
                    res[0] = aI.get(0);
                    res[1] = aI.get(1);
                    break;
                }

                List<Integer> rI = map.get(r);
                res[0] = aI.get(0);
                res[1] = rI.get(0);
                break;
            }
        }

        Arrays.sort(res);

        return res;
    }

    static int hackerlandRadioTransmitters(int[] x, int k) {
        if (null == x || x.length <= 0 || k > 100000) {
            return 0;
        }
        
        Arrays.parallelSort(x);

        int c = 0;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : x) {
            map.put(i, i);
        }

        int max = map.lastKey();
        Integer min = map.firstKey();
        while (min < max) {
            int seeker = min + k;
            Integer f = map.floorKey(seeker);
            c++;

            min = map.ceilingKey(f + k + 1);
            if(min == null) {
                break;
            }
            if(max < f + k + 1) {
                min = f + k + 1;
            }
        }

        if (null != min && min == max) {
            c++;
        }

        return c;
    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        int count = 0;
        if (null == candles || candles.isEmpty() || candles.size() > 100000) {
            return count;
        }

        int max = 0;

        for (Integer h : candles) {
            if (max < h) {
                max = h;
                count = 0;
            } else if (max == h) {
                max++;
            }
        }
        
        "".equalsIgnoreCase(anotherString)

        return count;
    }
}
