package org.pilgrim.base;

class ValidSubarrays {
    public static int validSubarrays(int[] nums) {

        int r = 0;
        int s = 1;

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                if (a <= b) {
                    s++;
                } else {
                    break;
                }
            }
            r += s;
            s = 1;
        }

        return r;
    }

    public static void main(String[] args) {
        int[] ar = new int[] { 1, 4, 2, 5, 3 };
        System.out.println(validSubarrays(ar));
    }
}