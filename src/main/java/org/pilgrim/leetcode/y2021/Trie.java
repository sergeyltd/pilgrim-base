package org.pilgrim.leetcode.y2021;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    
    char val;
    boolean leaf;
    Map<Character, Trie> children = new HashMap<>();

    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null){
            return;
        }
        
        Trie node = this;
        
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            Trie trie = node.children.get(ch);
            if(trie == null){
                trie = new Trie();
                trie.val = ch;
                node.children.put(ch, trie);
            }
            
            node = trie;
        }
        
        node.leaf = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = _startWith(word);
        if(node == null){
            return false;
        }
        
        return node.leaf;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        // if(prefix == null){
        //     return false;
        // }
        
        return null != _startWith(prefix);
    }
    
    private Trie _startWith(String prefix){
        if(prefix == null){
            return null;
        }
        
        Trie node = this;
        int i=0;
        for(i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            node = node.children.get(ch);
            if(node == null){
                return null;
            }
        }
        
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */