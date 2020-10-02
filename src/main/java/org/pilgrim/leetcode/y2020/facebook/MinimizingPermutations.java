package org.pilgrim.leetcode.y2020.facebook;

public class MinimizingPermutations {

    int minOperations(int[] arr) {
        // Write your code here
        
        if(arr == null || arr.length <= 0) {
            return 0;
        }
        
        int[] a = arr;
        
        int count = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if(i+1 == a[i]) {
                continue;
            }
            
            int st = i;
            int en = st;
            for (int j = i+1; j < a.length; j++) {
                if(a[j] == i + 1) {
                    en = j;
                    break;
                }
            }
            
            revers(a, st, en);
            count++;
        }
        
        return count;
    }
    
    void revers(int[] a, int i, int j) {
        int stop = (j-i)/2 + i + 1;
        for (; i<stop; i++, j--) {
            swap(a,i,j);
        }
    }
    
    void swap(int[]a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
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

        int n_1 = 5;
        int[] arr_1 = { 1, 2, 5, 4, 3 };
        int expected_1 = 1;
        int output_1 = minOperations(arr_1);
        check(expected_1, output_1);

        int n_2 = 3;
        int[] arr_2 = { 3, 1, 2 };
        int expected_2 = 2;
        int output_2 = minOperations(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new MinimizingPermutations().run();
    }
}
