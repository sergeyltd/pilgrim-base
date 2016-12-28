package org.pilgrim.hiredintech;
/*
 * 
315. Count of Smaller Numbers After Self   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 24104
Total Submissions: 72278
Difficulty: Hard
Contributors: Admin
You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Return the array [2, 1, 1, 0].
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.time.StopWatch;

public class CountSmallerNumbersAfterSelf {
    public static List<Integer> countSmaller(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int key = nums[i];
            int index = Collections.binarySearch(list, key);
            if (index >= 0) {
                while (index - 1 >= 0 && key == list.get(index - 1).intValue()) {
                    index--;
                }
                res.add(index);
                list.add(index, key);
            } else {
                index = index * (-1) - 1;
                res.add(index);
                list.add(index, key);
            }
        }
        Collections.reverse(res);
        return res;
    }

    public static List<Integer> countSmallerNxN(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                count += t > nums[j] ? 1 : 0;
            }
            res.add(count);
        }
        return res;
    }

    public static void main(String[] args) {
        {
            int[] a = { 5, 2, 6, 1 };
            List<Integer> list = countSmaller(a);
            System.out.println(list);
        }
        {
            int[] a = { 4, 3, 2, 1 };
            List<Integer> list = countSmaller(a);
            System.out.println(list);
        }
        {
            int[] a = { 1, 2, 3, 4 };
            List<Integer> list = countSmaller(a);
            System.out.println(list);
        }
        {
            int[] a = { 1, 1 };
            List<Integer> list = countSmaller(a);
            System.out.println(list);
        }
        {
            int[] a = { 6, 5, 5, 6, 6, 6, 1, 1 };
            List<Integer> list = countSmaller(a);
            System.out.println(list);
        }
        {
            int[] a = new int[1000000];
            for (int i = 0; i < a.length; i++) {
                a[a.length - i - 1] = i;
            }
            {
                StopWatch t = new StopWatch();
                t.start();
                List<Integer> list = countSmaller(a);
                t.stop();
                System.out.println("O(n*lg(n))" + t.getTime());
                System.out.println(list.subList(0, 100));
            }
            {
                StopWatch t = new StopWatch();
                t.start();
                List<Integer> list = countSmallerNxN(a);
                t.stop();
                System.out.println("O(n*n)" + t.getTime());
                System.out.println(list.subList(0, 100));
            }
        }
        // {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int[] a = new int[n];
        // for (int i = 0; i < a.length; i++) {
        // a[i] = sc.nextInt();
        // }
        // sc.close();
        // List<Integer> list = countSmaller(a);
        // System.out.println(list);
        // }
    }
}
