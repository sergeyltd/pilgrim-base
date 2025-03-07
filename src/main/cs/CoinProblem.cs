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
    Dictionary<int, int> cache = new Dictionary<int, int>();
    public int CoinChange(int[] coins, int amount) {
        var res = dp(coins, amount, 0);
        return res == int.MaxValue ? -1 : res;
    }

    private int dp(int[] coins, int amount, int iteration){
        if(amount == 0){
            return iteration;
        }

        if(amount < 0){
            return int.MaxValue;
        }

        int min = int.MaxValue;
        for (int i=0; i < coins.Length; i++){
            var newAmount = amount - coins[i];
            if (this.cache.TryGetValue(newAmount, out int value)){
                min = value;
                continue;
            }

            min = Math.Min(min, dp(coins, newAmount, iteration + 1));
            this.cache.TryAdd(newAmount, min);
        }

        return min;
    }
}