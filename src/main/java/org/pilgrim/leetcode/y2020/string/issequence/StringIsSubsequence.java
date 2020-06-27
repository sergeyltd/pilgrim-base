package org.pilgrim.leetcode.y2020.string.issequence;

public class StringIsSubsequence {
    public boolean isSubsequence2(String s, String t) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        if (t == null || t.isEmpty()) {
            return false;
        }

        if (s.charAt(0) == t.charAt(0)) {
            return isSubsequence2(s.substring(1), t.substring(1));
        } else {
            return isSubsequence2(s, t.substring(1));
        }
    }

    public boolean isSubsequence(String s, String t) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        if (t == null || t.isEmpty()) {
            return false;
        }
        int sIn = 0;
        int sEnd = s.length();

        int tIn = 0;
        int tEnd = t.length();

        while (sIn < sEnd && tIn < tEnd) {
            if (s.charAt(sIn) == t.charAt(tIn++)) {
                sIn++;
            }
        }

        return sIn == sEnd;
    }
}