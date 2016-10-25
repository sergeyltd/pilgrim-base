package org.pilgrim.base;

public class StringCompare
{
    static boolean strcmp(String str,
                          String pattern,
                          int i,
                          int j)
    {
        if (str.length() == i && pattern.length() == j) { return true; }

        // Make sure that the characters after '*' are present
        // in second string. This function assumes that the first
        // string will not contain two consecutive '*'
        if (pattern.charAt(j) == '*' && pattern.length() != j && str.length() == i)
            return false;

        if (str.charAt(j) == pattern.charAt(j))
            return strcmp(str, pattern, i + 1, j + 1);

        // If there is *, then there are two possibilities
        // a) We consider current character of second string
        // b) We ignore current character of second string.
        if (pattern.charAt(j) == '*')
            return strcmp(str, pattern, i, j + 1) || strcmp(str, pattern, i + 1, j);
        return false;
    }

    static boolean strcmp(String str,
                          String patter)
    {
        return strcmp(str, patter, 0, 0);
    }

    static boolean strcmp2(String str,
                           String pattern)
    {
        int[][] a = new int[str.length() + 1][pattern.length() + 1];
        int max = 0;

        int ps = 0;
        for (int i = 0; i < pattern.length(); i++)
        {
            char ch = pattern.charAt(i);
            if (ch != '*')
            {
                ps++;
            }
        }

        for (int i = 1; i <= str.length(); i++)
        {
            char sch = str.charAt(i - 1);
            for (int j = 1; j <= pattern.length(); j++)
            {
                char pch = pattern.charAt(j - 1);
                int count = a[i - 1][j - 1];
                if (pch == '*' || pch == sch)
                {
                    count++;
                }
                a[i][j] = count;
                max = Math.max(max, a[i][j]);
            }
        }

        return ps == max;
    }

    static boolean strcmp3(String str,
                           String pattern)
    {
        return strcmp3(str.toCharArray(), pattern.toCharArray(), str.length(), pattern.length());
    }

    static boolean strcmp3(char str[],
                           char pattern[],
                           int n,
                           int m)
    {
        // empty pattern can only match with
        // empty string
        if (m == 0)
            return (n == 0);

        // lookup table for storing results of
        // subproblems
        boolean[][] lookup = new boolean[n + 1][m + 1];

        // empty pattern can match with empty string
        lookup[0][0] = true;

        // Only '*' can match with empty string
        for (int j = 1; j <= m; j++)
            if (pattern[j - 1] == '*')
                lookup[0][j] = lookup[0][j - 1];

        // fill the table in bottom-up fashion
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                // Two cases if we see a '*'
                // a) We ignore ‘*’ character and move
                //    to next  character in the pattern,
                //     i.e., ‘*’ indicates an empty sequence.
                // b) '*' character matches with ith
                //     character in input
                if (pattern[j - 1] == '*')
                    lookup[i][j] = lookup[i][j - 1] || lookup[i - 1][j];

                // Current characters are considered as
                // matching in two cases
                // (a) current character of pattern is '?'
                // (b) characters actually match
                else if (/*pattern[j - 1] == '?' ||*/
                str[i - 1] == pattern[j - 1])
                {
                    lookup[i][j] = lookup[i - 1][j - 1];
                }

                // If characters don't match
                else
                {
                    lookup[i][j] = false;
                }
            }
        }
        return lookup[n][m];
    }

    public static void main(String[] args)
    {

    }
}
