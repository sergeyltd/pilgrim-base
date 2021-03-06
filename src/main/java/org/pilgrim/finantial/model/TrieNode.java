package org.pilgrim.finantial.model;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    char ch;
    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isLeaf;
    int deep;
    String word;
    String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    protected void setCh(char ch) {
        this.ch = ch;
    }

    protected void setChildren(Map<Character, TrieNode> children) {
        this.children = children;
    }

    protected void setLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    protected void setDeep(int deep) {
        this.deep = deep;
    }

    protected void setWord(String word) {
        this.word = word;
    }

    public TrieNode() {
    }

    public TrieNode(char c) {
        this.ch = c;
    }

    public char getCh() {
        return ch;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public int getDeep() {
        return deep;
    }

    public String getWord() {
        return word;
    }
}
