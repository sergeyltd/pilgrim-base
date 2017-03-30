package org.pilgrim.base.array;

import org.junit.Assert;
import org.junit.Test;

public class FindSmallestCommonNumberTest {
	@Test
	public void test() {
		FindSmallestCommonNumber commonNumber = new FindSmallestCommonNumber();
		int[] a = { 1, 2, 4, 7, 10 };
		int[] b = { 4, 12, 22 };
		int[] c = { 3, 4, 100 };

		int min = commonNumber.findCommonMinimum(a, b, c);
		Assert.assertEquals(4, min);
	}

	@Test
	public void test2() {
		FindSmallestCommonNumber commonNumber = new FindSmallestCommonNumber();
		int[] a = { 1, 2, 4, 7, 10 };
		int[] b = { 4, 12, 22 };
		int[] c = { 3, 5, 100 };

		int min = commonNumber.findCommonMinimum(a, b, c);
		Assert.assertEquals(Integer.MIN_VALUE, min);
	}

	@Test
	public void test3() {
		FindSmallestCommonNumber commonNumber = new FindSmallestCommonNumber();
		int[] a = { 1, 1, 1, 1, 4 };
		int[] b = { 4, 12, 22 };
		int[] c = { 3, 4, 100 };

		int min = commonNumber.findCommonMinimum(a, b, c);
		Assert.assertEquals(4, min);
	}

	@Test
	public void test4() {
		FindSmallestCommonNumber commonNumber = new FindSmallestCommonNumber();
		int[] a = { 1, 1, 1, 1, 4 };
		int[] b = { 4, 4, 4, 4, 4, 4, 4, 12, 22 };
		int[] c = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 4, 100 };

		int min = commonNumber.findCommonMinimum(a, b, c);
		Assert.assertEquals(4, min);
	}
}
