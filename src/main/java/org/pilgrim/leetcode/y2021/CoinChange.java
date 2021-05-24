package org.pilgrim.leetcode.y2021;

import java.util.Arrays;

public class CoinChange {
    public int coinChange3(int[] coins, int amount) {
        if (coins == null || coins.length <= 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        return _coinChange(coins, amount);
    }

    private int _coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int t = _coinChange(coins, amount - coins[i]);
            if (t < 0) {
                continue;
            }
            min = Math.min(min, t) + 1;
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // The fastest
    public int coinChange2(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        int[] coins = new int[] { 186, 419, 83, 408 };
        int amount = 6249;
        int h = c.coinChange(coins, amount);
        System.out.println(h);
    }
}