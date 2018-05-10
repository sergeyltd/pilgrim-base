package org.pilgrim.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * 
 * Note: Each element in the result should appear as many times as it shows in
 * both arrays. The result can be in any order. Follow up: What if the given
 * array is already sorted? How would you optimize your algorithm? What if
 * nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such
 * that you cannot load all elements into the memory at once?
 * 
 * @author segoncha
 *
 */
public class IntersectionTwoArraysII {

	public static void main(String[] args) {
		int[] a = { 1, 2, 2, 3 };
		int[] b = { 2, 2 };
		System.out.println(Arrays.toString(intersect(a, b)));

	}

	public static int[] intersect(int[] a, int[] b) {
		// Arrays.asList(Arrays.stream(a).boxed().toArray(Integer[]::new));
		Map<Integer, Integer> m1 = groupToMap(a);
		Map<Integer, Integer> m2 = groupToMap(b);

		if (m1.size() > m2.size()) {
			Map<Integer, Integer> t = m1;
			m1 = m2;
			m2 = t;
		}

		List<Integer> list = new ArrayList<>();

		Iterator<Map.Entry<Integer, Integer>> iterator = m1.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, Integer> next = iterator.next();

			Integer key = next.getKey();
			if (m2.containsKey(key)) {
				Integer v1 = next.getValue();
				Integer v2 = m2.get(key);

				int minValue = Math.min(v1, v2);
				for (int i = 0; i < minValue; i++) {
					list.add(key);
				}

				m2.remove(key);
				iterator.remove();
			}
		}

		return list.stream().flatMapToInt(x -> IntStream.of(x.intValue())).toArray();
	}

	private static Map<Integer, Integer> groupToMap(int[] a) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : a) {
			Integer count = map.get(i);
			if(null == count){
				count = 0;				
			}
			map.put(i, ++count);
		}
		return map;
	}
}
