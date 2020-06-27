package org.pilgrim.leetcode.y2020.search.insert.position;

public class SearchInsertPosition {

    // O(nums.length)
    public int searchInsert2(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }

        return nums.length;
    }

    // O(log(nums.length))
    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }

        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int m = (j + i) / 2;
            if (target == nums[m]) {

                // To support duplication
                int r = m--;
                while (m >= 0 && target == nums[m]) {
                    r = m--;
                }

                return r;
            } else if (target > nums[m]) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }

        return i;
    }
}