package org.pilgrim.finantial.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word, String category) {
        Map<Character, TrieNode> children = root.children;

        word = word.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            sb.append(c);

            TrieNode t;
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                t.setDeep(i);
                t.setWord(sb.toString());
                children.put(c, t);
            }

            children = t.children;

            // set leaf node
            if (i == word.length() - 1)
            {
                t.isLeaf = true;
                t.setWord(word);
                t.setCategory(category);
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchNode(word);

        if (t != null && t.isLeaf)
            return true;
        else
            return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (searchNode(prefix) == null)
            return false;
        else
            return true;
    }

    public TrieNode searchNode(String str) {
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else {
                return null;
            }
        }

        return t;
    }

    public TrieNode searchPrefix(String str) {
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else {
                return t;
            }
        }

        return t;
    }
    
    public List<TrieNode> getAllLeaf(TrieNode root){
        List<TrieNode> list = new ArrayList<>();
        if(null == root) {
            return null;
        }
        
        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TrieNode node = queue.poll();
            if(node.isLeaf())
            {
                list.add(node);
            }

            queue.addAll(node.getChildren().values());
        }
        
        return list;
    }
}