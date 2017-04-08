package org.pilgrim.base.array;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class LowHighIndexTest {
	@Test
	public void test1() {
		LowHighIndex highIndex = new LowHighIndex();
		int[] a = { 1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7 };
		int[] res = highIndex.find(a, 1);
		assertArrayEquals(new int[] { 0, 4 }, res);
	}

	@Test
	public void test2() {
		LowHighIndex highIndex = new LowHighIndex();
		int[] a = { 1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7 };
		int[] res = highIndex.find(a, 2);
		assertArrayEquals(new int[] { 5, 5 }, res);
	}

	@Test
	public void test3() {
		LowHighIndex highIndex = new LowHighIndex();
		int[] a = { 1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7 };
		int[] res = highIndex.find(a, 7);
		assertArrayEquals(new int[] { 10, 10 }, res);
	}

	@Test
	public void test4() {
		LowHighIndex highIndex = new LowHighIndex();
		int[] a = { 1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7 };
		int[] res = highIndex.find(a, 10);
		assertArrayEquals(new int[] { -1 }, res);
	}

	@Test
	public void test5() {
		LowHighIndex highIndex = new LowHighIndex();
		int[] a = { 0, 0, 0, 1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7 };
		int[] res = highIndex.find(a, 0);
		assertArrayEquals(new int[] { 0, 2 }, res);
	}

	@Test
	public void test6() {
		LowHighIndex highIndex = new LowHighIndex();
		int[] a = { 0, 1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7 };
		int[] res = highIndex.find(a, 0);
		assertArrayEquals(new int[] { 0, 0 }, res);
	}

	@Test
	public void test7() {
		LowHighIndex highIndex = new LowHighIndex();
		int[] a = { 0, 1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7 };
		int[] res = highIndex.find(a, 1);
		assertArrayEquals(new int[] { 1, 5 }, res);
	}

	@Test
	public void test8() {
		LowHighIndex highIndex = new LowHighIndex();
		int[] a = { -1, 1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7 };
		int[] res = highIndex.find(a, -1);
		assertArrayEquals(new int[] { 0, 0 }, res);
	}

	@Test
	public void test9() {
		LowHighIndex highIndex = new LowHighIndex();
		int[] a = { 7 };
		int[] res = highIndex.find(a, 0);
		assertArrayEquals(new int[] { -1 }, res);
	}

	@Test
	public void test10() {
		LowHighIndex highIndex = new LowHighIndex();
		int[] a = { 7 };
		int[] res = highIndex.find(a, 7);
		assertArrayEquals(new int[] { 0, 0 }, res);
	}

	@Test
	public void test11() {
		LowHighIndex highIndex = new LowHighIndex();
		int[] a = {};
		int[] res = highIndex.find(a, 0);
		assertArrayEquals(new int[] { -1 }, res);
	}
}
