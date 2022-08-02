package org.pilgrim.leetcode.y2022;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Note: here provided backtrack algorithm with big O by time in exponential O(S^n)
 */
public class CoinChange {	
	public static void main(String[] args) {
		CoinChange cc = new CoinChange();
		System.out.println(cc.coinChange(new int[] {1,3,4,5}, 7));
	}

	int globalMin = Integer.MAX_VALUE;

	public int coinChange(int[] coins, int amount) {
		if (coins == null || coins.length <= 0 || amount < 0 || coins.length > 12) {
			return -1;
		}

		return helper(coins, amount, 0);
	}

	private int helper(int[] coins, int amount, int iteration) {
		if (amount == 0) {
			return iteration;
		}

		if (amount < 0) {
			return -1;
		}

		if (iteration > globalMin) {
			return -1;
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			int count = helper(coins, amount - coins[i], iteration + 1);
			if (count < 0) {
				continue;
			}

			min = Math.min(min, count);
			globalMin = Math.min(min, globalMin);
		}

		int ans = min == Integer.MAX_VALUE ? -1 : min;
		return ans;
	}
}
