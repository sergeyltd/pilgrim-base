package org.pilgrim.leetcode.y2022;

/**
 * 
 * 127. Word Ladder
Hard

https://leetcode.com/problems/word-ladder/

8079

1653

Add to List

Share
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLedder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		// Validate input
		if (beginWord == null || endWord == null || wordList == null) {
			return 0;
		}

		wordList.add(beginWord);

		// pattern to list of words
		Map<String, Set<String>> patToWordMap = new HashMap<>();

		// word to list of patterns
		Map<String, Set<String>> wordToPat = new HashMap<>();

		for (String word : wordList) {
			for (int i = 0; i < word.length(); i++) {
				String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
				patToWordMap.putIfAbsent(pattern, new HashSet<String>());
				patToWordMap.get(pattern).add(word);

				wordToPat.putIfAbsent(word, new HashSet<String>());
				wordToPat.get(word).add(pattern);
			}
		}

		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		int res = 1;
		Queue<String> q = new LinkedList<String>();
		q.add(beginWord);
		while (!q.isEmpty()) {
			int size = q.size();
			while (size > 0) {
				String node = q.poll();
				if (node.equals(endWord)) {
					return res;
				}

				Set<String> patterns = wordToPat.get(node);
				for (String patt : patterns) {
					Set<String> wds = patToWordMap.get(patt);

					for (String wd : wds) {
						if (!visited.contains(wd)) {
							q.add(wd);
							visited.add(wd);
						}
					}
				}
				size--;
			}

			res++;
		}

		return 0;
	}
}
