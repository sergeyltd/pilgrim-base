package org.pilgrim.base.array;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotateArrayTest {
	@Test
	public void testRotate1() {
		RotateArray rotateArray = new RotateArray();
		int [] a = {1,2,3,4,5,6,7};
		rotateArray.rotate(a, 3);
		assertArrayEquals(new int[]{5,6,7,1,2,3,4}, a);
	}
	
	@Test
	public void testRotate2() {
		RotateArray rotateArray = new RotateArray();
		int [] a = {1,2,3,4,5,6,7};
		rotateArray.rotate(a, 2);
		assertArrayEquals(new int[]{6,7,1,2,3,4,5}, a);
	}
	
	@Test
	public void testRotate3() {
		RotateArray rotateArray = new RotateArray();
		int [] a = {1,2,3,4,5,6,7};
		rotateArray.rotate(a, 0);
		assertArrayEquals(new int[]{1,2,3,4,5,6,7}, a);
	}

	@Test
	public void testRotate4() {
		RotateArray rotateArray = new RotateArray();
		int [] a = {1,2,3,4,5,6,7};
		rotateArray.rotate(a, -1);
		assertArrayEquals(new int[]{1,2,3,4,5,6,7}, a);
	}
}
