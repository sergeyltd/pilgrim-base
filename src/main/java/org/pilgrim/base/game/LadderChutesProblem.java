/**
 * Snake and Ladder Problem
Given a snake and ladder board, find the minimum number of dice throws required to reach
the destination or last cell from source or 1st cell. Basically, the player has total control
over outcome of dice throw and wants to find out minimum number of throws required to reach last cell.

If the player reaches a cell which is base of a ladder, the player has to climb up that
ladder and if reaches a cell is mouth of the snake, has to go down to the tail of snake without a dice throw.

snakesladders

For example consider the board shown on right side (taken from here),
the minimum number of dice throws required to reach cell 30 from cell 1 is 3. Following are steps.

a) First throw two on dice to reach cell number 3 and then ladder to reach 22
b) Then throw 6 to reach 28.
c) Finally through 2 to reach 30.

There can be other solutions as well like (2, 2, 6), (2, 4, 4), (2, 3, 5).. etc.

We strongly recommend to minimize the browser and try this yourself first.
The idea is to consider the given snake and ladder board as a directed graph with number
of vertices equal to the number of cells in the board. The problem reduces to finding the shortest
path in a graph. Every vertex of the graph has an edge to next six vertices
if next 6 vertices do not have a snake or ladder. If any of the next six vertices has a snake or ladder,
then the edge from current vertex goes to the top of the ladder or tail of the snake.
Since all edges are of equal weight, we can efficiently find shortest path using Breadth First Search of the graph.
 */
package org.pilgrim.base.game;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LadderChutesProblem
{
    static class Node
    {
        public Node(int v,
                    int d)
        {
            this.v = v;
            this.d = d;
        }

        int v;
        int d;

        @Override
        public String toString()
        {
            StringBuilder builder = new StringBuilder();
            builder.append("v=");
            builder.append(v);
            builder.append(", d=");
            builder.append(d);
            return builder.toString();
        }
    }

    public static int findMinMove(int[] board,
                                  int n)
    {
        int m = -1;
        boolean[] visitted = new boolean[n];
        visitted[0] = true;
        Queue<Node> q = new LinkedList<>();
        Node qn = new Node(0, 0);
        q.add(qn);

        int d = 0;
        while (!q.isEmpty())
        {
            qn = q.peek();
            int v = qn.v;

            if (v == n - 1)
            {
                break;
            }

            q.poll();

            for (int j = v + 1; j <= (v + 6) && j < n; j++)
            {
                if (!visitted[j])
                {
                    Node s = new Node(0, qn.d + 1);
                    visitted[j] = true;
                    if (board[j] == -1)
                    {
                        s.v = j;
                    }
                    else
                    {
                        s.v = board[j];
                    }
                    q.add(s);
                }
            }
        }

        if (qn.v == n - 1)
        {
            m = qn.d;
        }
        return m;
    }

    public static void main(String[] args)
    {
        int n = 100;
        int a[] = new int[n];
        Arrays.fill(a, -1);
        a[2] = 70;//ladder from 2 to 70
        a[71] = 60;//chute from 71 to 60
        a[61] = 99;//ladder from 61 to 99

        int min = findMinMove(a, n);
        System.out.println(min);
    }
}
