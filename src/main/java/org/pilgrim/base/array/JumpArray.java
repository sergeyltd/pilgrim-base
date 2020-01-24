package org.pilgrim.base.array;

public class JumpArray {

    public static boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[] {30,3,2,0,0,0,0,1}));
    }
}
