package org.pilgrim.hiredintech;

import java.util.Scanner;

/**
 * Your submission will run against only preliminary test cases. Full test cases will run at the end of the day.
Marc is young lover of strings who wants your help with the following problem. Given a string, , of lowercase English alphabetic letters and an integer, , calculate the number of string 's such that:

Each  consists of lowercase English alphabetic letters
, meaning their concatenation is commutative.
Print the number of string 's modulo .

Input Format

The first line contains a string denoting . 
The second line contains an integer denoting .

Constraints

 consists of lowercase English alphabetic letters only (i.e.,  to ).
Output Format

Print the number of string 's satisfying the conditions above, modulo .

Sample Input

abc
6
Sample Output

2
Explanation

Given  abc, we have two possible string 's satisfying  and :

 abc
 abcabc.
Thus, we print  on a new line.
 * @author sergeyg
 *
 */
public class UnexpectedProblem
{
    public static String findReplica(String str)
    {
        String reploca = str;

        String tpm = "";

        for (int i = 1; i < str.length() / 2; i++)
        {
            if (str.length() % i == 0)
            {
                tpm = str.substring(0, i);
                int counts = str.length() / i;
                boolean found = false;
                for (int j = 0; j < counts - 1; j++)
                {
                    String ordeonar = str.substring((j + 1) * i, (j + 1) * i + i);
                    if (!tpm.equals(ordeonar))
                    {
                        found = false;
                        break;
                    }
                    found = true;
                }
                if (found)
                {
                    str = tpm;
                }
            }
        }

        return str;
    }
    //    
    //    public static void main(String[] args)
    //    {
    //        String replica = findReplica("ababababab");
    //        System.out.println(replica);
    //    }

    public static void main(String[] args)
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int m = in.nextInt();
        String replica = findReplica(str);
        System.out.println(m / replica.length());
    }
}
