package org.pilgrim.leetcode.y2020.facebook;

import java.util.Arrays;

public class SlowSums {
    int getTotalTime(int[] arr) {
        // Write your code here

        if (arr == null || arr.length <= 0) {
            return 0;
        }

        if (arr.length == 1) {
            return arr[0];
        }

        int s = 0;

        // there are 3 possible solution
        // 1. Sort array
        // traverse from tail to head do calculation
        Arrays.sort(arr);

        for (int i = arr.length - 1; i > 0; i--) {
            int a = arr[i] + arr[i - 1];
            s += a;
            arr[i - 1] = a;
        }

        // 2. Use Max Heap
        // do in a loop get first 2, sum them and sum back

        // 3. Every time traverse array and find 2 max elements

        return s;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        int[] arr_1 = { 4, 2, 1, 3 };
        int expected_1 = 26;
        int output_1 = getTotalTime(arr_1);
        check(expected_1, output_1);

        int[] arr_2 = { 2, 3, 9, 8, 4 };
        int expected_2 = 88;
        int output_2 = getTotalTime(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new SlowSums().run();
    }
}
