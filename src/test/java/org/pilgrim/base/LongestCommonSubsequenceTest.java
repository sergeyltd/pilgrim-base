package org.pilgrim.base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestCommonSubsequenceTest
{
    @Test
    public void testLcs()
    {
        LongestCommonSubsequence f = new LongestCommonSubsequence();
        int len = f.lcs("abc123", "abc");
        assertEquals(3, len);
    }
//
//    @Test
//    public void testLcs2()
//    {
//        LongestCommonSubsequence f = new LongestCommonSubsequence();
//        int len = f.lcs("abc123", "abc12");
//        assertEquals(5, len);
//    }
//
//    @Test
//    public void testLcs3()
//    {
//        LongestCommonSubsequence f = new LongestCommonSubsequence();
//        int len = f.lcs("abc123", "rabc12");
//        assertEquals(5, len);
//    }
//
//    @Test
//    public void testLcs4()
//    {
//        LongestCommonSubsequence f = new LongestCommonSubsequence();
//        int len = f.lcs(null, "rabc12");
//        assertEquals(0, len);
//    }
//
//    @Test
//    public void testLcs5()
//    {
//        LongestCommonSubsequence f = new LongestCommonSubsequence();
//        int len = f.lcs("", "rabc12");
//        assertEquals(0, len);
//    }
//
//    @Test
//    public void testLcs6()
//    {
//        LongestCommonSubsequence f = new LongestCommonSubsequence();
//        int len = f.lcs("abc123", null);
//        assertEquals(0, len);
//    }
//
//    @Test
//    public void testLcs7()
//    {
//        LongestCommonSubsequence f = new LongestCommonSubsequence();
//        int len = f.lcs("abc123", "");
//        assertEquals(0, len);
//    }
//
//    @Test
//    public void testLcs8()
//    {
//        LongestCommonSubsequence f = new LongestCommonSubsequence();
//        int len = f.lcs("", "");
//        assertEquals(0, len);
//    }
//
//    @Test
//    public void testLcs9()
//    {
//        LongestCommonSubsequence f = new LongestCommonSubsequence();
//        int len = f.lcs(null, null);
//        assertEquals(0, len);
//    }
//
//    @Test
//    public void testLcs10()
//    {
//        LongestCommonSubsequence f = new LongestCommonSubsequence();
//        int len = f.lcs("", null);
//        assertEquals(0, len);
//    }
//
//    @Test
//    public void testLcs11()
//    {
//        LongestCommonSubsequence f = new LongestCommonSubsequence();
//        int len = f.lcs(null, "");
//        assertEquals(0, len);
//    }
//
//    @Test
//    public void testLcs12()
//    {
//        LongestCommonSubsequence f = new LongestCommonSubsequence();
//        int len = f.lcs("a", "a");
//        assertEquals(1, len);
//    }
//
//    @Test
//    public void testLcs13()
//    {
//        LongestCommonSubsequence f = new LongestCommonSubsequence();
//        int len = f.lcs("a", "b");
//        assertEquals(0, len);
//    }
//
//    @Test
//    public void testLcs14()
//    {
//        LongestCommonSubsequence f = new LongestCommonSubsequence();
//        int len = f.lcs("ab", "ac");
//        assertEquals(1, len);
//    }
//
//    @Test
//    public void testLcs15()
//    {
//        LongestCommonSubsequence f = new LongestCommonSubsequence();
//        int len = f.lcs("ac", "ca");
//        assertEquals(1, len);
//    }
//
//    @Test
//    public void testLcs16()
//    {
//        LongestCommonSubsequence f = new LongestCommonSubsequence();
//        int len = f.lcs("abcdefg", "c");
//        assertEquals(1, len);
//    }
//
//    @Test
//    public void testLcs17()
//    {
//        LongestCommonSubsequence f = new LongestCommonSubsequence();
//        int len = f.lcs("abcdefg", "a");
//        assertEquals(1, len);
//    }
//
//    @Test
//    public void testLcs18()
//    {
//        LongestCommonSubsequence f = new LongestCommonSubsequence();
//        int len = f.lcs("abcdefg", "g");
//        assertEquals(1, len);
//    }
//
//    @Test
//    public void testLcs19()
//    {
//        String string = "C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDCC4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDCC4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDCC4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDCC4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDCC4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDCC4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDCC4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDCC4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDCC4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDCC4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDCC4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDCC4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDCC4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDCC4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDCC4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDCC4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDCC4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDCC4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDCC4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDCC4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDCC4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDCC4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDCC4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDCC4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDCC4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC78RJUT4KD5F9C4HMKZ4CJFZDC";
//        int length = string.length();
//        LongestCommonSubsequence f = new LongestCommonSubsequence();
//        int len = f.lcs(string, new StringBuilder(string).deleteCharAt(100).toString());
//        assertEquals(length-1, len);
//    }
}
