/*

*/

public class ClimbingStairs
{
    private Dictionary<int, int> cache = new ();
    
    public int ClimbStairs(int n) {
        if(n<0){
            return 0;
        }

        return fib(n+1);
    }

    public int ClimbStairsV2(int n) {
        // For steps less than 4 the number of distinct ways equals to number of steps on staircase.
        if (n <= 3){
            return n;
        }

        // Check on cache
        if (cache.TryGetValue(n, out var value)){
            return value;
        }

        // dp(n) = dp(n-1) + dp(n-2)
        var result = this.ClimbStairsV2(n - 1) + this.ClimbStairsV2(n - 2);

        // Store to the cache
        cache[n] = result;

        return result;
    }
    
    public static int fib(int n) {
        double sqrt5 = Math.Sqrt(5);
        double fibn = Math.Pow((1 + sqrt5) / 2, n) - Math.Pow((1 - sqrt5) / 2, n);
        return (int) (fibn / sqrt5);
    }
}