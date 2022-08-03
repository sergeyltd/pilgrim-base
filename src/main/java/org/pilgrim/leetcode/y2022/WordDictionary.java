package org.pilgrim.leetcode.y2022;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 211. Design Add and Search Words Data Structure
Medium

5215

260

Add to List

Share
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
 *
 */

public class WordDictionary {
	public static void main(String[] args) {

	}

	Trie trie = new Trie();

	public WordDictionary() {

	}

	public void addWord(String word) {
		this.trie.insert(word);
	}

	public boolean search(String word) {
		return this.trie.search(word);
	}
}

class Trie {

	private TrieNode root = new TrieNode();

	public Trie() {

	}

	public void insert(String word) {
		if (word == null || word.isEmpty()) {
			return;
		}

		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);

			node.children.putIfAbsent(ch, new TrieNode());
			node = node.children.get(ch);
		}

		node.isWord = true;
		node.word = word;
	}

	public boolean search(String word) {
		TrieNode node = this.seek(root, word, 0);

		return node == null ? false : node.isWord;
	}

	public boolean startsWith(String prefix) {
		TrieNode node = this.seek(root, prefix, 0);

		return node == null ? false : true;
	}

	private TrieNode seek(TrieNode root, String word, int index) {
		if (word == null || word.isEmpty()) {
			return null;
		}

		TrieNode node = root;
		for (int i = index; i < word.length(); i++) {
			char ch = word.charAt(i);

			if (ch == '.') {
				TrieNode lastRes = null;
				for (TrieNode trn : node.children.values()) {
					TrieNode res = this.seek(trn, word, i + 1);
					if (res != null && res.isWord) {
						return res;
					}

					lastRes = res;
				}

				return lastRes;
			}

			node = node.children.get(ch);

			if (node == null) {
				return null;
			}
		}

		return node;
	}
}

class TrieNode {
	Map<Character, TrieNode> children = new HashMap<>();
	String word;
	boolean isWord;
}
