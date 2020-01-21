package org.pilgrim.base;

public class ClimbStairs {

    // Brute force O(2^n)
    public static int climbStairs_bf(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return climbStairs_bf(n - 1) + climbStairs_bf(n - 2);
    }

    public static int fib(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n) - Math.pow((1 - sqrt5) / 2, n);
        return (int) (fibn / sqrt5);
    }

    public static int climbStairs_fib(int n) {
        return fib(n + 1);
    }

    public static void main(String[] args) {        
        for (int i=0; i<12; i++) {
            System.out.println(climbStairs_bf(i));
            System.out.println(climbStairs_fib(i));
        }        
    }

}
