package org.pilgrim.base.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestUniqueSubstring {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int ans = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!set.contains(ch)) {
                set.add(ch);
                ans = Math.max(set.size(), ans);
            } else {
                while (ch != s.charAt(j)) {
                    set.remove(s.charAt(j++));
                }
                while (ch == s.charAt(j) && j < i) {
                    j++;
                }
                set.add(ch);
            }
        }

        return ans;
    }

    public static int lengthOfLongestSubstring_leetcode(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int n = s.length();
        int i = 0;
        int j = 0;
        int ans = 0;

        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return ans;
    }
    
    public int lengthOfLongestSubstring_leetcode2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aabaab!bb"));
    }

}
