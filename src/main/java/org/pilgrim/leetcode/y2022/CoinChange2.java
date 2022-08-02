package org.pilgrim.leetcode.y2022;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different
 * denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If
 * that amount of money cannot be made up by any combination of the coins,
 * return -1. You may assume that you have an infinite number of each kind of
 * coin.
 *
 * Note: here provided bottom up dynamic solution algorithm with big O by time
 * in exponential O(S * n)
 */
public class CoinChange2 {
	public static void main(String[] args) {
		CoinChange2 cc = new CoinChange2();

		int max = 0;
		for (int i = 1; i <= 100; i++) {
			int count = cc.coinChange(new int[] { 1, 2, 3, 5, 10, 15, 20, 50, 100 }, i);
			System.out.println("#" + i + ": " + count);

			max = Math.max(max, count);
		}

		System.out.println("Max number of coins: " + max);
	}

	public int coinChange(int[] coins, int amount) {
		if (coins == null || coins.length <= 0 || amount < 0 || coins.length > 12) {
			return -1;
		}

		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);

		dp[0] = 0;

		for (int a = 1; a < dp.length; a++) {
			for (int c : coins) {
				if (a - c >= 0) {
					dp[a] = Math.min(dp[a], 1 + dp[a - c]);
				}
			}
		}

		return dp[amount] == amount + 1 ? -1 : dp[amount];
	}
}
