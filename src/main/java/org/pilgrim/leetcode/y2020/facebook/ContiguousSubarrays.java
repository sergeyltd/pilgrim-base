package org.pilgrim.leetcode.y2020.facebook;

import java.util.Arrays;

public class ContiguousSubarrays {
    int[] countSubarrays(int[] arr) {
        // Write your code here

        if (arr == null || arr.length <= 0) {
            return new int[0];
        }

        int[] res = new int[arr.length];

        Arrays.fill(res, 1);

        for (int i = 0; i < arr.length; i++) {
            res[i] += countSubArray(arr, i, 1);
            res[i] += countSubArray(arr, i, -1);
        }

        return res;

    }

    private int countSubArray(int[] a, int i, int step) {
        int s = 0;
        int m = a[i];
        i += step;

        while (i >= 0 && i < a.length) {
            if (a[i] < m) {
                s++;
            } else {
                break;
            }

            i += step;
        }

        return s;
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
        int[] test_1 = { 3, 4, 1, 6, 2 };
        int[] expected_1 = { 1, 3, 1, 5, 1 };
        int[] output_1 = countSubarrays(test_1);
        check(expected_1, output_1);

        int[] test_2 = { 2, 4, 7, 1, 5, 3 };
        int[] expected_2 = { 1, 2, 6, 1, 3, 1 };
        int[] output_2 = countSubarrays(test_2);
        check(expected_2, output_2);

        int[] test_3 = { 2, 5, 9, 7, 4, 1, 6, 3 };
        int[] expected_3 = { 1, 2, 8, 5, 2, 1, 4, 1 };
        int[] output_3 = countSubarrays(test_3);
        check(expected_3, output_3);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new ContiguousSubarrays().run();
    }
}
