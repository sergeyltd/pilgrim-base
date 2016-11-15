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
