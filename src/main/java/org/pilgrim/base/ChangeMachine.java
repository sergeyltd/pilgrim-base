package org.pilgrim.base;

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class ChangeMachine
{
    static public int all_comb(int sum,
                               int[] coins,
                               Stack<Integer> stack,
                               int startIndex)
    {
        int combsCounter = 0;
        if (sum < 0) { return 0; }
        if (sum == 0)
        {
            System.out.println(Arrays.toString(stack.toArray()));
            return 1;
        }

        for (int i = startIndex; i < coins.length; i++)
        {
            int c = coins[i];
            stack.push(c);
            combsCounter += all_comb(sum - c, coins, stack, i);
            stack.pop();
        }
        return combsCounter;
    }

    static int sum(Queue<Integer> queue)
    {
        int[] sum = { 0 };
        queue.stream().forEach(i -> sum[0] = sum[0] + i);
        return sum[0];
    }

    public static void main(String[] args)
    {
        {
            int[] coins = { 1, 2 };
            int combsCounter = all_comb(6, coins, new Stack<Integer>(), 0);
            System.out.println("******");
            System.out.println(combsCounter);
            System.out.println("======");
            System.out.println();
        }
        {
            int[] coins = { 1, 2 };
            int combsCounter = all_comb(6, coins, new Stack<Integer>(), 0);
            System.out.println("******");
            System.out.println(combsCounter);
            System.out.println("======");
            System.out.println();
        }
        {
            int[] coins = { 1, 2, 3 };
            int combsCounter = all_comb(6, coins, new Stack<Integer>(), 0);
            System.out.println("******");
            System.out.println(combsCounter);
            System.out.println("======");
            System.out.println();
        }
        {
            int[] coins = { 1, 2, 5 };
            int combsCounter = all_comb(6, coins, new Stack<Integer>(), 0);
            System.out.println("******");
            System.out.println(combsCounter);
            System.out.println("======");
            System.out.println();
        }
        {
            int[] coins = { 1, 5, 10, 25 };
            int combsCounter = all_comb(63, coins, new Stack<Integer>(), 0);
            System.out.println("******");
            System.out.println(combsCounter);
            System.out.println("======");
            System.out.println();
        }
        {
            int[] coins = { 1, 5, 10, 25 };
            int combsCounter = all_comb(25, coins, new Stack<Integer>(), 0);
            System.out.println("******");
            System.out.println(combsCounter);
            System.out.println("======");
            System.out.println();
        }
    }
}
