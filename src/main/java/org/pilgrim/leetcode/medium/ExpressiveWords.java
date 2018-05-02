package org.pilgrim.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Sometimes people repeat letters to represent extra feeling, such as "hello"
 * -> "heeellooo", "hi" -> "hiiii". Here, we have groups, of adjacent letters
 * that are all the same character, and adjacent characters to the group are
 * different. A group is extended if that group is length 3 or more, so "e" and
 * "o" would be extended in the first example, and "i" would be extended in the
 * second example. As another example, the groups of "abbcccaaaa" would be "a",
 * "bb", "ccc", and "aaaa"; and "ccc" and "aaaa" are the extended groups of that
 * string.
 * 
 * For some given string S, a query word is stretchy if it can be made to be
 * equal to S by extending some groups. Formally, we are allowed to repeatedly
 * choose a group (as defined above) of characters c, and add some number of the
 * same character c to it so that the length of the group is 3 or more. Note
 * that we cannot extend a group of size one like "h" to a group of size two
 * like "hh" - all extensions must leave the group extended - ie., at least 3
 * characters long.
 * 
 * Given a list of query words, return the number of words that are stretchy.
 * 
 * Example: Input: S = "heeellooo" words = ["hello", "hi", "helo"] Output: 1
 * Explanation: We can extend "e" and "o" in the word "hello" to get
 * "heeellooo". We can't extend "helo" to get "heeellooo" because the group "ll"
 * is not extended. Notes:
 * 
 * 0 <= len(S) <= 100. 0 <= len(words) <= 100. 0 <= len(words[i]) <= 100. S and
 * all words in words consist only of lowercase letters
 * 
 * @author segoncha
 *
 */
public class ExpressiveWords {
	class Pair {
		public char ch;
		public int count;

		@Override
		public String toString() {
			return "Pair [ch=" + ch + ", count=" + count + "]\n";
		}
	}

	public int expressiveWords(String S, String[] words) {
		int count = 0;

		if (null == S || S.isEmpty()) {
			return count;
		}

		List<Pair> list = fill(S);

		for (String word : words) {

			if (S.length() < word.length()) {
				continue;
			}

			List<Pair> w = fill(word);

			if (list.size() == w.size()) {
				boolean bb = true;
				for (int i = 0; i < list.size(); i++) {
					Pair pS = list.get(i);
					Pair pW = w.get(i);

					if (pW.ch != pS.ch) {
						bb = false;
						break;
					}

					int c = pS.count - pW.count;
//					if (c < 0 || c == 1) {
//						bb = false;
//						break;
//					}
					if (c < 0 || (pS.count <= 2 && c != 0)) {
						bb = false;
						break;
					}
				}
				if (bb) {
					count++;
				}
			}
		}
		return count;
	}

	private List<Pair> fill(String s) {
		List<Pair> list = new ArrayList<>();
		Pair obj = new Pair();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (obj.ch == (char) 0) {
				obj.ch = ch;
				obj.count = 1;
				list.add(obj);
			} else if (obj.ch == ch) {
				obj.count++;
			} else {
				obj = new Pair();
				obj.ch = ch;
				obj.count = 1;
				list.add(obj);
			}
		}

		return list;
	}

	public static void main(String[] args) {

		ExpressiveWords expressiveWords = new ExpressiveWords();
		System.out.println(expressiveWords.expressiveWords("dddiiiinnssssssoooo", new String[] { "dinnssoo", "ddinso",
				"ddiinnso", "ddiinnssoo", "ddiinso", "dinsoo", "ddiinsso", "dinssoo", "dinso" }));
	}
}
