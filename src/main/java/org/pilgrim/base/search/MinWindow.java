package org.pilgrim.base.search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinWindow {
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty() || s.length() < t.length()) {
            return "";
        }
        // s = s.toUpperCase();
        // t = t.toUpperCase();
        int n = s.length();
        int m = t.length();

        String minWord = "";

        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        for (char ch : t.toCharArray()) {
            set.add(ch);
        }

        int gs = 0;

        Map<Character, Integer> w = new HashMap<>();
        while (i < n && j < n) {
            char ch = s.charAt(i++);
            if (set.contains(ch)) {
                Integer count = w.get(ch);
                if (count == null) {
                    count = 0;
                }
                w.put(ch, ++count);
                gs++;
            }

            if (gs == m) {
                if (!set.contains(s.charAt(j))) {
                    j = findNextTchar(s, j, set);
                }
                String tWord = s.substring(j, i);
                if (minWord.isEmpty() || tWord.length() < minWord.length()) {
                    minWord = tWord;
                }
            }

            while (gs == m) {
                char cch = s.charAt(j++);
                Integer count = w.get(cch);
                if (count != null) {
                    count--;
                    gs--;

                    if (count == 0) {
                        w.remove(cch);
                    } else {
                        w.put(cch, count);
                    }
                }
            }

            if (j < n && !set.contains(s.charAt(j))) {
                j = findNextTchar(s, j, set);
            }
        }

        return minWord;

    }

    static int findNextTchar(String t, int st, Set<Character> set) {
        for (int i = st; i < t.length(); i++) {
            if (set.contains(t.charAt(i))) {
                return i;
            }
        }

        return t.length() - 1;
    }

    public static String minWindow_leet(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        // Number of unique characters in t, which need to be present in the desired
        // window.
        int required = dictT.size();

        // Left and Right pointer
        int l = 0, r = 0;

        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;

        // Dictionary which keeps a count of all the unique characters in the current
        // window.
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

        // ans list of the form (window length, left, right)
        int[] ans = { -1, 0, 0 };

        while (r < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = s.charAt(l);
                // Save the smallest window until now.
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }

                // Move the left pointer ahead, this would help to look for a new window.
                l++;
            }

            // Keep expanding the window once we are done contracting.
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public static void main(String[] args) {

        String s = "bba";
        String t = "ab";

        System.out.println("*********************");
        System.out.println(minWindow_leet(s, t));
    }

}
