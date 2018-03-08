package org.pilgrim.base;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class StringPermutationWithoutRepeats {
	public void permutation(String input) {
		Map<Character, Integer> map = new TreeMap<>();
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			Integer count = map.get(ch);
			if (null == count) {
				count = 0;
			}
			count++;
			map.put(ch, count);
		}

		char[] str = new char[map.size()];
		int[] counts = new int[map.size()];
		char[] res = new char[input.length()];

		int index = 0;
		for (Entry<Character, Integer> item : map.entrySet()) {
			str[index] = item.getKey();
			counts[index] = item.getValue();
			index++;
		}

		permutationUtil(str, counts, res, 0);
	}

	private void permutationUtil(char[] str, int[] counts, char[] res, int level) {
		if (res.length == level){
			printCharArray(res);
			return;
		}
		
		for (int i = 0; i < str.length; i++) {
			if(counts[i] == 0){
				continue;
			}
			
			counts[i]--;
			
			res[level] = str[i];
			permutationUtil(str, counts, res, level + 1);
			
			counts[i]++;
		}
	}

	private void printCharArray(char[] res) {
		System.out.println(String.valueOf(res));
	}
	
	public static void main(String[] args) {
		StringPermutationWithoutRepeats repeats = new StringPermutationWithoutRepeats();
		repeats.permutation("aabc");
	}
}
