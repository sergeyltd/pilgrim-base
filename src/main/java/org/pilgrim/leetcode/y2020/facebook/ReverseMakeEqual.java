package org.pilgrim.leetcode.y2020.facebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReverseMakeEqual {
    // Add any helper functions you may need here

    boolean areTheyEqual(int[] a, int[] b) {
        // Write your code here

        if (a == null && b != null || a != null && b == null || a.length != b.length) {
            return false;
        }

        boolean res = true;
        // 1. use sorting
        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < b.length && res; i++) {
            res = a[i] == b[i];
        }

        // 2. use hash map
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < b.length; i++) {
            Integer count = map.get(a[i]);
            if (count == null) {
                count = 0;
            }
            map.put(a[i], ++count);
        }

        for (int i = 0; i < b.length && res; i++) {
            Integer count = map.get(b[i]);
            res = count != null;
            if (res) {
                count--;
                if (count <= 0) {
                    map.remove(b[i]);
                } else {
                    map.put(b[i], count);
                }
            }
        }

        return res;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printString(String str) {
        System.out.print("[" + str + "]");
    }

    public void run() {
        int[] array_a_1 = { 1, 2, 3, 4 };
        int[] array_b_1 = { 1, 4, 3, 2 };
        boolean expected_1 = true;
        boolean output_1 = areTheyEqual(array_a_1, array_b_1);
        check(expected_1, output_1);

        int[] array_a_2 = { 1, 2, 3, 4 };
        int[] array_b_2 = { 1, 4, 3, 3 };
        boolean expected_2 = false;
        boolean output_2 = areTheyEqual(array_a_2, array_b_2);
        check(expected_2, output_2);
        // Add your own test cases here

    }

    public static void main(String[] args) {
        new ReverseMakeEqual().run();
    }
}
