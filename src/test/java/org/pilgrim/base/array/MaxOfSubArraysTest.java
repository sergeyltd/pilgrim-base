package org.pilgrim.base.array;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MaxOfSubArraysTest {

	@Test
	public void test1() {
		int[] a1 = { 1, 2, 3, 4, 5, 6 };
		List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(3, 4, 5, 6));
		assertTrue(list1.equals(MaxOfSubArrays.maxList(a1, 3)));
	}

	@Test
	public void test2() {
		int[] a2 = { 6, 5, 4, 3, 2, 1 };
		List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(6, 5, 4, 3));
		assertTrue(list2.equals(MaxOfSubArrays.maxList(a2, 3)));
	}
	
	@Test
	public void test3() {
		int[] a2 = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
		List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(3, 3, 4, 5, 5, 5, 6));
		assertTrue(list2.equals(MaxOfSubArrays.maxList(a2, 3)));
	}
}