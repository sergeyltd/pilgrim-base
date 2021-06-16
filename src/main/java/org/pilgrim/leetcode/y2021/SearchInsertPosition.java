package org.pilgrim.leetcode.y2021;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
Example 4:

Input: nums = [1,3,5,6], target = 0
Output: 0
Example 5:

Input: nums = [1], target = 0
Output: 0
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
 * @author sergiy
 *
 */

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length <= 0){
            return 0;
        }
        
        int lo = 0;
        int hi = nums.length - 1;
        
        // Input: nums = [1,3,5,6], target = 5
        // Output: 2
        
        while(lo <= hi){
            int m = (hi - lo)/2 + lo;
            if(nums[m] == target){
                return m;
            }
            else if( nums[m] < target){
                lo = m + 1;
            }
            else{
                hi = m - 1;
            }
        }
        
        return lo;
    }
}