package org.pilgrim.leetcode.y2020.facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchWord2 {

	static class TrieNode {
		Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		String word = null;

		public TrieNode() {
		}
	}
	
	static int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};

	char[][] _board = null;
	List<String> _result = new ArrayList<String>();

	public List<String> findWords(char[][] board, String[] words) {

		// Step 1). Construct the Trie
		TrieNode root = new TrieNode();
		for (String word : words) {
			TrieNode node = root;

			for (char letter : word.toCharArray()) {
				if (node.children.containsKey(letter)) {
					node = node.children.get(letter);
				} else {
					TrieNode newNode = new TrieNode();
					node.children.put(letter, newNode);
					node = newNode;
				}
			}
			node.word = word; // store words in Trie
		}

		this._board = board;
		// Step 2). Backtracking starting for each cell in the board
		for (int row = 0; row < board.length; ++row) {
			for (int col = 0; col < board[row].length; ++col) {
				if (root.children.containsKey(board[row][col])) {
					backtracking(row, col, root);
				}
			}
		}

		return this._result;
	}

	private void backtracking(int row, int col, TrieNode parent) {
		char letter = this._board[row][col];
		TrieNode currNode = parent.children.get(letter);

		// check if there is any match
		if (currNode.word != null) {
			this._result.add(currNode.word);
			currNode.word = null;
		}

		// mark the current letter before the EXPLORATION
		this._board[row][col] = '#';

		// explore neighbor cells in around-clock directions: up, right, down, left
		for (int i = 0; i < 4; ++i) {
			int newRow = row + d[i][0];
			int newCol = col + d[i][1];
			if (newRow < 0 || newRow >= this._board.length || newCol < 0 || newCol >= this._board[0].length) {
				continue;
			}
			if (currNode.children.containsKey(this._board[newRow][newCol])) {
				backtracking(newRow, newCol, currNode);
			}
		}

		// End of EXPLORATION, restore the original letter in the board.
		this._board[row][col] = letter;

		// Optimization: incrementally remove the leaf nodes
		if (currNode.children.isEmpty()) {
			parent.children.remove(letter);
		}
	}

	public static void main(String[] args) {

		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		String[] words = { "oath", "pea", "eat", "rain" };
		
		SearchWord2 searchWord2 = new SearchWord2();
		List<String> res = searchWord2.findWords(board, words);
		System.out.println(String.join(",", res));
	}
}
