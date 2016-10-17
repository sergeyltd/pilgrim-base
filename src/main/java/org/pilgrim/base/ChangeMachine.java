package org.pilgrim.base;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ChangeMachine
{
    static public int all_comb(int sum,
                               int[] coins,
                               Queue<Integer> queue,
                               int st)
    {
        int combsCounter = 0;
        if (sum < 0) { return 0; }
        if (sum == 0)
        {
            System.out.println(Arrays.toString(queue.toArray()));
            return 1;
        }

        for (int i = 0; i < coins.length; i++)
        {
            int c = coins[i];
            if (st > c)
            {
                continue;
            }
            queue.add(c);
            combsCounter += all_comb(sum - c, coins, queue, i + 1);
            queue.poll();
        }
        return combsCounter;
    }

    public static void main(String[] args)
    {
        {
            int[] coins = { 1, 2 };
            int combsCounter = all_comb(6, coins, new LinkedList<Integer>(), coins[0]);
            System.out.println("******");
            System.out.println(combsCounter);
            System.out.println("======");
            System.out.println();
        }
        {
            int[] coins = { 1, 2 };
            int combsCounter = all_comb(6, coins, new LinkedList<Integer>(), coins[0]);
            System.out.println("******");
            System.out.println(combsCounter);
            System.out.println("======");
            System.out.println();
        }
        {
            int[] coins = { 1, 2, 3 };
            int combsCounter = all_comb(6, coins, new LinkedList<Integer>(), coins[0]);
            System.out.println("******");
            System.out.println(combsCounter);
            System.out.println("======");
            System.out.println();
        }
        {
            int[] coins = { 1, 2, 5 };
            int combsCounter = all_comb(6, coins, new LinkedList<Integer>(), coins[0]);
            System.out.println("******");
            System.out.println(combsCounter);
            System.out.println("======");
            System.out.println();
        }
        {
            int[] coins = { 1, 2, 5, 10, 25 };
            int combsCounter = all_comb(63, coins, new LinkedList<Integer>(), coins[0]);
            System.out.println("******");
            System.out.println(combsCounter);
            System.out.println("======");
            System.out.println();
        }
    }
}
