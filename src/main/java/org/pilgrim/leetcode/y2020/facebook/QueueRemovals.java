package org.pilgrim.leetcode.y2020.facebook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueRemovals {

    // Add any helper functions you may need here

    class Node {
        public int i;
        public int v;

        public Node(int i, int v) {
            this.i = i;
            this.v = v;
        }
    }

    int[] findPositions(int[] arr, int x) {
        // Write your code here

        if (arr == null || arr.length <= 0) {
            return null;
        }

        int[] res = new int[x];

        Queue<Node> q = new LinkedList<Node>();
        for (int i = 0; i < arr.length; i++) {
            q.add(new Node(i, arr[i]));
        }

        for (int j = 0; j < res.length; j++) {
            List<Node> list = new ArrayList<Node>();

            Node max = null;
            for (int k = 0; k < x && !q.isEmpty(); k++) {
                Node cur = q.poll();
                list.add(cur);
                if (max == null) {
                    max = cur;
                }
                if (max.v < cur.v) {
                    max = cur;
                }
            }

            for (Iterator iterator = list.iterator(); iterator.hasNext();) {
                Node node = (Node) iterator.next();
                if (node == max) {
                    iterator.remove();
                } else {
                    if (node.v > 0) {
                        node.v--;
                    }

                    q.add(node);
                }
            }

            res[j] = max.i + 1;
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
        int n_1 = 6;
        int x_1 = 5;
        int[] arr_1 = { 1, 2, 2, 3, 4, 5 };
        int[] expected_1 = { 5, 6, 4, 1, 2 };
        int[] output_1 = findPositions(arr_1, x_1);
        check(expected_1, output_1);

        int n_2 = 13;
        int x_2 = 4;
        int[] arr_2 = { 2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4 };
        int[] expected_2 = { 2, 5, 10, 13 };
        int[] output_2 = findPositions(arr_2, x_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new QueueRemovals().run();
    }
}