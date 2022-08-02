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
public class CoinChange3 {
	public static void main(String[] args) {
		int max = 0;
		for (int i = 1; i <= 30; i++) {
			int count = minCoinsChangeWithLimitedCoins(new int[] { 1, 2, 3, 5 }, new int[] { 2, 1, 2, 2 }, i);
			System.out.println("#" + i + ": " + count);

			max = Math.max(max, count);
		}

		System.out.println("Max number of coins: " + max);
	}
	
	private static int minCoinsChangeWithLimitedCoins(int[] coins, int[] counts, int amount)
    {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) // n
        {
            int coin = coins[i];
            for (int j = 0; j < counts[i]; j++) // 
            {
                for (int a = amount; a >= coin ; a--) // sum
                {
                    int remainder = a - coin;
                    if (remainder >= 0)
                    {
                        dp[a] = Math.min(dp[a], 1 + dp[remainder]);
                    }
                }
            }

        }
        
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
