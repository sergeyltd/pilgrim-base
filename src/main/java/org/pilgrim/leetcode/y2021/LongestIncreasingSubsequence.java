package org.pilgrim.leetcode.y2021;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
Medium

8316

181

Add to List

Share
Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 */

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length <= 0){
            return 0;
        }
        
        int len = 1;
        int[] sorted = new int[nums.length];
        sorted[0] = nums[0];
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            int idx = Arrays.binarySearch(sorted, 0, len, num);
            if (idx < 0) {
                //System.out.println(idx);
                idx = ~idx;
                //System.out.println(idx);
            }
            if (idx == len) {
                sorted[len++] = num;
            } else {
                sorted[idx] = num;
            }
            
            //System.out.println(Arrays.toString(sorted));
        }
        return len;
    }
    
    public int lengthOfLIS2(int[] nums) {
        if(nums == null || nums.length <= 0){
            return 0;
        }
        
        int[] a = nums;
        int[] t = new int[nums.length];
        Arrays.fill(t, 1);
        int max = 1;
        
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                //System.out.println(a[i] + "<" + a[j]);
                if(a[i] > a[j]){
                    t[i] = Math.max(t[i], t[j] + 1);
                    max = Math.max(t[i], max);
                }
            }
            
            //System.out.println(Arrays.toString(t));
        }
        
        return max;
    }
}