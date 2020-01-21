package org.pilgrim.base;

import java.util.HashMap;

public class Fibonacci {

    public static int fibonacci_01(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fibonacci_01(n - 1) + fibonacci_01(n - 2);
    }
    
    static HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

    public static int fib(int N) {
      if (cache.containsKey(N)) {
        return cache.get(N);
      }
      int result;
      if (N < 2) {
        result = N;
      } else {
        result = fib(N-1) + fib(N-2);
      }
      // keep the result in cache.
      cache.put(N, result);
      return result;
    }
    
    public static int fibFastest(int n) {
        double sqrt5=Math.sqrt(5);
        double fibn=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
        return (int)(fibn/sqrt5);
    }

    public static void main(String[] args) {
        int n = 30;
        System.out.println(fibonacci_01(n));
        System.out.println(fib(n));
        System.out.println(fibFastest(n-1));
    }

}
