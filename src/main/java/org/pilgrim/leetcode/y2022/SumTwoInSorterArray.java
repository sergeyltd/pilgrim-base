package org.pilgrim.leetcode.y2022;

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
