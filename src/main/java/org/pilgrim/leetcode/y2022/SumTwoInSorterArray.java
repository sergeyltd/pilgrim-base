package org.pilgrim.leetcode.y2022;

/**
 * 
 * 167. Two Sum II - Input Array Is Sorted
Medium

5664

953

Add to List

Share
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

 

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 

Constraints:

2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution.
 * 
 * 
 */

import java.util.Arrays;

public class SumTwoInSorterArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] indexes = twoSum(new int[] {1,2,3,4,4,9,56,90}, 8);
		System.out.println(Arrays.toString(indexes));
	}
	
	public static int[] twoSum(int[] arr, int k) {
        // Validate input values
        if(arr == null || arr.length <= 1 || arr.length > 3 * 10000 || k< -1000 || k > 1000){
            return null;
        }
        
        // Traverse array from both sides
        int[] res = new int[] {-1, -1};
        int i = 0;
        int j = arr.length - 1;
        while(i < j){
            int s = arr[i] + arr[j];
            if(k == s){
                res[0] = i+1;
                res[1] = j+1;
                break;
            }
            else if(k > s){
                i++;
                while(i < j && arr[i] == arr[i+1] && arr[i]*2 != k){
                    i++;
                }
            }
            else if(k < s){
                j--;
                while(i < j && arr[j] == arr[j - 1] && arr[j]*2 != k){
                    j--;
                }
            }
        }
        
        return res;
    }
	
	public static int[] twoSum2(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            int mid = left + (right - left) / 2;
            if (sum > target)
                if (numbers[left] + numbers[mid] > target)
                    right = mid - 1;
                else
                    right--;
            else if (sum < target)
                if (numbers[mid] + numbers[right] < target)
                    left = mid + 1;
                else
                    left++;
            else
                return new int[] {left +1, right + 1};
        }
        return null;
    }

}
