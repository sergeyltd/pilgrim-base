package org.pilgrim.leetcode.y2022;

import java.util.Stack;

public class Pattern132 {

    public static void main(String[] args) {
        Pattern132 pattern132 = new Pattern132();
        int[] input = {3,1,4,2};
        boolean res = pattern132.find132pattern(input);
        
        System.out.println(res);
    }

    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();

        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }

        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j]) {
                    stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() < nums[j]) {
                    return true;
                }

                stack.push(nums[j]);
            }
        }
        return false;
    }

}
