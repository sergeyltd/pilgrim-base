package org.pilgrim.base.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MaxOfSubArrays {

	private MaxOfSubArrays() {
	}

	public static List<Integer> maxList(int[] a, int k) {
		if (k <= 0) {
			throw new IllegalArgumentException("The value of k should atleast be 1.");
		}

		final Deque<Integer> deque = new ArrayDeque<Integer>();
		final List<Integer> result = new ArrayList<Integer>();

		int i;
		for (i = 0; i < k; i++) {
			while (!deque.isEmpty() && a[deque.peek()] <= a[i]) {
				deque.removeFirst();
			}
			deque.addLast(i);
		}

		for (; i < a.length; i++) {
			result.add(a[deque.peek()]);

			while (!deque.isEmpty() && deque.peek() <= i - k) {
				deque.removeFirst();
			}

			while (!deque.isEmpty() && a[deque.peek()] <= a[i]) {
				deque.removeFirst();
			}

			deque.addLast(i);
		}

		result.add(a[deque.peek()]);
		return result;
	}
}