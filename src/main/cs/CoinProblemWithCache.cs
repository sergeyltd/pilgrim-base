/*

322. Coin Change

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
*/

public class Solution {
    Dictionary<int, long> cache = new Dictionary<int, long>();
    public int CoinChange(int[] coins, int amount) {
        var res = dp(coins, amount);
        return res >= int.MaxValue ? -1 : (int)res;
    }

    private long dp(int[] coins, int amount){
        if(amount == 0){
            return 0L;
        }

        if(amount < 0){
            return int.MaxValue;
        }

        if (this.cache.TryGetValue(amount, out long value)){
            return value;
        }

        long min = int.MaxValue;
        for (int i=0; i < coins.Length; i++){
            var newAmount = amount - coins[i];
            min = Math.Min(min, dp(coins, newAmount) + 1L);
        }

        this.cache.TryAdd(amount, min);

        return min;
    }
}