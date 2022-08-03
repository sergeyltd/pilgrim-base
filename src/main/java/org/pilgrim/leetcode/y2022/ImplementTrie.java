package org.pilgrim.leetcode.y2022;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 208. Implement Trie (Prefix Tree)
Medium

7769

96

Add to List

Share
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 

Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
 *
 */

public class ImplementTrie {

	public static void main(String[] args) {

	}

	class Trie {
	    
	    private TrieNode root = new TrieNode();

	    public Trie() {
	        
	    }
	    
	    public void insert(String word) {
	        if(word == null || word.isEmpty()){
	            return;
	        }
	        
	        TrieNode node = root;
	        for(int i=0; i<word.length(); i++){
	            char ch = word.charAt(i);
	            
	            node.children.putIfAbsent(ch, new TrieNode());
	            node = node.children.get(ch);
	        }
	        
	        node.isWord = true;
	        node.word = word;
	    }
	    
	    public boolean search(String word) {
	        TrieNode node = this.seek(word);
	        
	        return node == null ? false : node.isWord;
	    }
	    
	    public boolean startsWith(String prefix) {
	        TrieNode node = this.seek(prefix);
	        
	        return node == null ? false : true;
	    }
	    
	    private TrieNode seek(String word){
	        if(word == null || word.isEmpty()){
	            return null;
	        }
	        
	        TrieNode node = root;
	        for(int i=0; i<word.length(); i++){
	            char ch = word.charAt(i);
	            node = node.children.get(ch);
	            
	            if(node == null){
	                return null;
	            }
	        }
	        
	        return node;
	    }
	}

	class TrieNode{
	    Map<Character, TrieNode> children = new HashMap<>();
	    String word;
	    boolean isWord;
	}
}
