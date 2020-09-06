package org.pilgrim.leetcode.y2020.facebook;

import java.util.Arrays;

public class PairSum {

    public static void main(String[] args) {
        new PairSum().run();

    }

    int numberOfWays(int[] arr, int k) {
        // Write your code here
        
        if(arr == null || arr.length <= 0) {
            return 0;
        }
        Arrays.sort(arr);

        int res = 0;
        int n = arr.length;

        int i = 0;
        int j = n - 1;
        while (i < j) {
            int s = arr[i] + arr[j];
            if (s == k) {
                if (arr[i] == arr[j]) {
                    double g = j - i + 1;
                    res += (g - 1.0) / 2.0 * g;
                    break;
                } else {
                    res++;
                    i++;
                }
            } else if (s > k) {
                j--;
            } else {
                i++;
            }

        }

        return res;
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
        int k_1 = 6;
        int[] arr_1 = { 1, 2, 3, 4, 3 };
        int expected_1 = 2;
        int output_1 = numberOfWays(arr_1, k_1);
        check(expected_1, output_1);

        int k_2 = 6;
        int[] arr_2 = { 1, 5, 3, 3, 3 };
        int expected_2 = 4;
        int output_2 = numberOfWays(arr_2, k_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

}
