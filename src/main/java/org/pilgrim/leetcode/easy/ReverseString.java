package org.pilgrim.leetcode.easy;

/**
 * Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".


 * @author segoncha
 *
 */
public class ReverseString {
    public static String reverseString(String s) {
    	if(null == s || s.isEmpty()){
            return s;
        }
        int len = s.length() - 1;
        int len2 = s.length()/2;
        char[] chs = s.toCharArray();
        for(int i=0;i<len2;i++){
            char tch = chs[i];
            chs[i] = chs[len-i];
            chs[len-i] = tch;
            
            System.out.println(String.valueOf(chs));
        }
        return String.valueOf(chs);
    }
    
    public String reverseString2(String s) {
        if(null == s || s.isEmpty()){
            return s;
        }
        int len = s.length();
        char[] chs = new char[len];
        for(int i=0;i<=len/2;i++){
            chs[i] = s.charAt(len-i-1);
            chs[len-i-1] = s.charAt(i);
        }
        return String.valueOf(chs);
    }
    
    public String reverseString3(String s) {
        boolean hasSurrogates = false;
        int n = s.length() - 1;
        for (int i = (n-1)/2; i >= 0; i--) {
            int k = n - i;
            char cj = s.charAt(i);
            char ck = s.charAt(k);
            value[i] = ck;
            value[k] = cj;
            if (Character.isSurrogate(cj) ||
                Character.isSurrogate(ck)) {
                hasSurrogates = true;
            }
        }
        if (hasSurrogates) {
            reverseAllValidSurrogatePairs();
        }
        return this;
    }
    
    public static void main(String[] args) {
		System.out.println(reverseString("hello"));
	}
}
