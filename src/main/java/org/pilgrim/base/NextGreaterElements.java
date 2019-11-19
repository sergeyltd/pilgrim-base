package org.pilgrim.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null) {
            return null;
        }

        int[] res = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int key = nums[i];
            for (int j = i + 1; true; j++) {
                int k = j % nums.length;
                if (k == i) {
                    res[i] = -1;
                    break;
                }
                if (nums[k] > key) {
                    res[i] = nums[k];
                    break;
                } else if (res[k] > key && k > i) {
                    res[i] = res[k];
                    break;
                }
            }
        }

        return res;
    }
    //
    // public int[] nextGreaterElements2(int[] nums) {
    // if (nums == null) {
    // return null;
    // }
    //
    // TreeMap<Integer, Integer> map = new TreeMap<>();
    // for (int i : nums) {
    // map.put(i, null);
    // }
    //
    // int[] res = new int[nums.length];
    // for (int i = 0; i < nums.length; i++) {
    // Integer key = nums[i];
    // Integer next = map.higherKey(key);
    // res[i] = next == null ? -1 : next;
    // }
    //
    // return res;
    // }

    public int nextGreaterElement3(int n) {
        int bucket[] = new int[10];
        int k = 1;
        int original = n;
        while (n != 0) {
            int curr = n % 10;
            bucket[curr]++;
            n -= curr;
            int num = 0;
            for (int i = curr + 1; i <= 9; i++) {
                if (bucket[i] != 0) {
                    num += i;
                    bucket[i]--;
                    break;
                }
            }
            if (num != 0) {
                int max = num;
                for (int i = 0; i <= 9; i++) {
                    int count = bucket[i];
                    while (count > 0) {
                        num = num * 10 + i;
                        count--;
                    }
                }
                bucket[max]++;
                if (num + n * k > original) {
                    return num + n * k;
                }
            }
            k *= 10;
            n /= 10;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = { 4, 5, 4, 3, 2, 1 };
        NextGreaterElements g = new NextGreaterElements();
        int[] res = g.nextGreaterElements(a);

        for (int i : res) {
            System.out.println(i);
        }

        System.out.println("++++++++++++");
        System.out.println(g.nextGreaterElement3(101));
        System.out.println(g.nextGreaterElement3(21));
        System.out.println(g.nextGreaterElement3(123));
    }
}