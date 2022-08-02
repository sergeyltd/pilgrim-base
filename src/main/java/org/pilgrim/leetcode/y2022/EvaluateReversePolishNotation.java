package org.pilgrim.leetcode.y2022;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length <= 0) {
			return -1;
		}

		long ans = 0;
		Stack<Long> stack = new Stack<>();
		for (String token : tokens) {
			if (token.equals("+")) {
				long d2 = Long.valueOf(stack.pop());
				long d1 = Long.valueOf(stack.pop());
				ans = d1 + d2;
				stack.push(ans);
			} else if (token.equals("-")) {
				long d2 = Long.valueOf(stack.pop());
				long d1 = Long.valueOf(stack.pop());
				ans = d1 - d2;
				stack.push(ans);
			} else if (token.equals("*")) {
				long d2 = Long.valueOf(stack.pop());
				long d1 = Long.valueOf(stack.pop());
				ans = d1 * d2;
				stack.push(ans);
			} else if (token.equals("/")) {
				long d2 = Long.valueOf(stack.pop());
				long d1 = Long.valueOf(stack.pop());
				ans = d1 / d2;
				stack.push(ans);
			} else {
				long d = Long.valueOf(token);
				stack.push(d);
			}
		}

		return (int) ans;
	}

}
