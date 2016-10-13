package org.pilgrim.base;

public class LongestCommonSubsequence
{
    //    public int lcs(String str1,
    //                   String str2)
    //    {
    //        if (null == str1 || null == str2 || str1.isEmpty() || str2.isEmpty()) { return 0; }
    //        return lcs(str1, 0, str1.length() - 1, str2, 0, str2.length() - 1);
    //    }

    private int lcs(String str1,
                    int i1,
                    int j1,
                    String str2,
                    int i2,
                    int j2)
    {
        if (i1 > j1 || i2 > j2) { return 0; }
        if (str1.charAt(j1) == str2.charAt(j2))
        {
            return 1 + lcs(str1, i1, j1 - 1, str2, i2, j2 - 1);
        }
        else
        {
            int len1 = lcs(str1, i1, j1 - 1, str2, i2, j2);
            int len2 = lcs(str1, i1, j1, str2, i2, j2 - 1);
            return Math.max(len1, len2);
        }
    }

    public int lcs(String str1,
                   String str2)
    {
        if (null == str1 || null == str2 || str1.isEmpty() || str2.isEmpty()) { return 0; }
        return find(str1.toCharArray(), str2.toCharArray());
    }

    public static int find(char[] A, char[] B) {
        int[][] LCS = new int[A.length + 1][B.length + 1];
        // if A is null then LCS of A, B =0
        for (int i = 0; i <= B.length; i++) {
            LCS[0][i] = 0;
        }

        // if B is null then LCS of A, B =0
        for (int i = 0; i <= A.length; i++) {
            LCS[i][0] = 0;
        }

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                } else {
                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                }
            }
        }
        for (int i = 1; i < LCS.length; i++) {
            for (int j = 1; j < LCS[0].length; j++) {
                    System.out.print(LCS[i][j] + ", ");
            }
            System.out.println();
        }
        return LCS[A.length][B.length];
    }
}
