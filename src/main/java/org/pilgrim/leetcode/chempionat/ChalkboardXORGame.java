package org.pilgrim.leetcode.chempionat;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Chalkboard XOR Game User Accepted: 1 User Tried: 1 Total Accepted: 1 Total
 * Submissions: 1 Difficulty: Hard We are given non-negative integers nums[i]
 * which are written on a chalkboard. Alice and Bob take turns erasing exactly
 * one number from the chalkboard, with Alice starting first. If erasing a
 * number causes the bitwise XOR of all the elements of the chalkboard to become
 * 0, then that player loses. (Also, we'll say the bitwise XOR of one element is
 * that element itself, and the bitwise XOR of no elements is 0.)
 * 
 * Return True if and only if Alice wins the game, assuming both players play
 * optimally.
 * 
 * Example: Input: nums = [1, 1, 2] Output: false Explanation: Alice has two
 * choices: erase 1 or erase 2. If she erases 1, the nums array becomes [1, 2].
 * The bitwise XOR of all the elements of the chalkboard is 1 XOR 2 = 3. Now Bob
 * can remove any element he wants, because Alice will be the one to erase the
 * last element and she will lose. If Alice erases 2 first, now nums becomes [1,
 * 1]. The bitwise XOR of all the elements of the chalkboard is 1 XOR 1 = 0.
 * Alice will lose.
 * 
 * Notes:
 * 
 * 0 <= N <= 1000. 0 <= nums[i] <= 2^16.
 * 
 * @author segoncha
 *
 */
public class ChalkboardXORGame {

	public boolean xorGame(int[] nums) {
		return xorGame(nums, true);
	}

	public boolean xorGame(int[] nums, boolean b) {

		if (nums.length == 1) {
			return !b;
		}

		boolean t = false;

		for (int i = 0; i < nums.length; i++) {
			int[] a = new int[nums.length - 1];
			int k = 0;
			for (int j = 0; j < nums.length; j++) {if (j == i) {continue;}a[k++] = nums[j];}
			
			int res = 0;
			for (int j : a) {res ^= j;}

			if (res == 0) {
				//t |= !b;
				continue;
			}
			
			t |= xorGame(a, !b);
			if (t) {
				break;
			}
		}

		return t;
	}

	public static void main(String[] args) {
		ChalkboardXORGame chalkboardXORGame = new ChalkboardXORGame();
		System.out.println(chalkboardXORGame.xorGame(new int[] { 1,2, 3 }));
	}
}
