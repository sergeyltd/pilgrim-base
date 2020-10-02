package org.pilgrim.leetcode.y2020.facebook;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PassingYearbooks {
    // Add any helper functions you may need here

    int[] findSignatureCounts(int[] a) {
        // Write your code here

        if (a == null || a.length <= 0) {
            return a;
        }

        int[] b = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            b[i]++;
            int k = a[i] - 1;
            while(k != i) {
                b[k]++;
                k = a[k] - 1;
            }
            
        }

        return b;
    }

    static void foo() {

        int[] nums1 = { 2, 1 };
        int[] nums2 = { 1, 2 };
        int[] nums3 = { 2, 1, 3 };
        int[] nums4 = { 4, 3, 2, 5, 1 };
        System.out.println(Arrays.toString(solve(nums1)));
        System.out.println(Arrays.toString(solve(nums2)));
        System.out.println(Arrays.toString(solve(nums3)));
        System.out.println(Arrays.toString(solve(nums4)));
    }

    private static int[] solve(int[] nums) {
        int[] res = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i + 1);
        }
        Set<Integer> visited = new HashSet<>();
        for (int k : map.keySet()) {
            if (!visited.contains(k)) {
                Set<Integer> round = new HashSet<>();
                while (!visited.contains(k)) {
                    round.add(k);
                    visited.add(k);
                    k = map.get(k);
                }
                for (int i : round) {
                    res[i - 1] = round.size();
                }
            }
        }
        return res;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public void run() {
        int[] arr_1 = { 2, 1 };
        int[] expected_1 = { 2, 2 };
        int[] output_1 = findSignatureCounts(arr_1);
        check(expected_1, output_1);

        int[] arr_2 = { 1, 2 };
        int[] expected_2 = { 1, 1 };
        int[] output_2 = findSignatureCounts(arr_2);
        check(expected_2, output_2);

        int[] arr_3 = { 2, 1, 3 };
        int[] expected_3 = { 2, 2, 1 };
        int[] output_3 = findSignatureCounts(arr_3);
        check(expected_3, output_3);

        int[] arr_4 = { 4, 3, 2, 5, 1 };
        int[] expected_4 = { 3, 2, 2, 3, 3 };
        int[] output_4 = findSignatureCounts(arr_4);
        check(expected_4, output_4);

        // Add your own test cases here

    }

    public static void main(String[] args) throws IOException {
        new PassingYearbooks().run();
    }
}
