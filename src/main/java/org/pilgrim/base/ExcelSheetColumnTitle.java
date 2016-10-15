package org.pilgrim.base;

import java.util.ArrayList;

/*
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet. For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 */
public class ExcelSheetColumnTitle {
	/**
	 * convert number to title
	 * 
	 * @param n
	 * @return
	 */
	public String convertToTitle(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("Input is not valid!");
		}

		StringBuilder sb = new StringBuilder();

		while (n > 0) {
			n--;
			char ch = (char) (n % 26 + 'A');
			n /= 26;
			sb.append(ch);
		}

		sb.reverse();
		return sb.toString();
	}

	/**
	 * convert title to number
	 * 
	 * @param s
	 * @return
	 */
	public int convertToNumber(String s) {
		if (s == null || s.length() == 0) {
			throw new IllegalArgumentException("Input is not valid!");
		}

		int result = 0;
		int i = s.length() - 1;
		int t = 0;
		while (i >= 0) {
			char curr = s.charAt(i);
			result = result + (int) Math.pow(26, t) * (curr - 'A' + 1);
			t++;
			i--;
		}

		return result;
	}

	static public String getPermutation(int n, int k) {

		// initialize all numbers
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			numberList.add(i);
		}

		// change k to be index
		k--;

		// set factorial of n
		int mod = 1;
		for (int i = 1; i <= n; i++) {
			mod = mod * i;
		}

		String result = "";

		// find sequence
		for (int i = 0; i < n; i++) {
			mod = mod / (n - i);
			// find the right number(curIndex) of
			int curIndex = k / mod;
			// update k
			k = k % mod;

			// get number according to curIndex
			result += numberList.get(curIndex);
			// remove from list
			numberList.remove(curIndex);
		}

		return result.toString();
	}

	static public void printExcelColumnTitle(int c) {
		char[] chs = new char[26];
		for (int i = 0; i < chs.length; i++) {
			chs[i] = (char) ('a' + i);
		}

		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < chs.length; i++) {
//			sb.append(chs[i]);
			print(chs, c, sb, 0);
//			sb.deleteCharAt(0);
//		}
	}

	private static void print(char[] chs, int c, StringBuilder sb, int i) {
		if (sb.length() >= c) {
			System.out.println(sb);
		} else {
			for (int j = i; j < chs.length; j++) {
				sb.append(chs[j]);
				print(chs, c, sb, j);
				sb.delete(sb.length()-1, sb.length());
			}
		}
	}
	
	public static void main(String[] args) {
		String permutation = getPermutation(5, 3);
		System.out.println(permutation);
		
		char[] a = { 'a', 'b', 'c' };
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.println("" + a[i] + "" + a[j]);
			}
		}
		
		printExcelColumnTitle(1);
		printExcelColumnTitle(2);
	}
}
