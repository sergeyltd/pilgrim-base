package org.pilgrim.leetcode.y2022;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int longestConsecutive(int[] nums) {
        // Validate input values
        if(nums == null){
            return 0;
        }
        
        Set<Integer> numSet = new HashSet<>();
        for(int i : nums){
            numSet.add(i);
        }
        
        int lagestC = 0;
        for(int i : numSet){
            if(!numSet.contains(i - 1)){
                int currNum = i;
                int currMax = 0;
                
                while(numSet.contains(currNum)){
                    currNum++;
                    currMax++;
                }
                
                lagestC = Math.max(lagestC, currMax);
            }
        }
        
        return lagestC;
    }	

	public int longestConsecutive2(int[] nums) {
        if (nums.length == 0) return 0;
        
        Arrays.sort(nums);
        
        int res = 1;
        int cur = 1;
        
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] - 1 == nums[i - 1]) {
                    cur++;
                } else {
                    res = Math.max(res, cur);
                    cur = 1;
                }
            }
        }
        
        return Math.max(res, cur);
    }
}
