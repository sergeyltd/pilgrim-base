package org.pilgrim.leetcode.easy;

import java.util.Stack;

/**
 * Given a string, you need to reverse the order of characters in each word
 * within a sentence while still preserving whitespace and initial word order.
 * 
 * Example 1: Input: "Let's take LeetCode contest" Output: "s'teL ekat edoCteeL
 * tsetnoc" Note: In the string, each word is separated by single space and
 * there will not be any extra space in the string.
 * 
 * 
 * @author segoncha
 *
 */
public class ReverseWordsStringIII {
	public static String reverseWords(String s) {
		if (null == s || s.isEmpty()) {
			return s;
		}

		StringBuilder sb = new StringBuilder(s.length());

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch != ' ') {
				stack.push(ch);
			} else {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(ch);
				stack.clear();
			}
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		return sb.toString();
	}
	
	public static String reverseWords2(String input) {
        final StringBuilder result = new StringBuilder();
        final StringBuilder word = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                word.append(input.charAt(i));
            } else {
                result.append(word.reverse());
                result.append(" ");
                word.setLength(0);
            }
        }
        result.append(word.reverse());
        return result.toString();
    }

	public static void main(String[] args) {
		System.out.println(reverseWords("Let's take LeetCode contest"));
		System.out.println(reverseWords2("Let's take LeetCode contest"));
	}
}
