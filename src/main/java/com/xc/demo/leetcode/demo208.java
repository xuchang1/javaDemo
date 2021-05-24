package com.xc.demo.leetcode;

public class demo208 {

}

class Trie {
    private boolean isWord;
    private Trie[] children;

    /** Initialize your data structure here. */
    public Trie() {
        isWord = false;
        children = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie current = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new Trie();
            }
            current = current.children[index];
        }
        current.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie current = find(word);
        return current != null && current.isWord;
    }

    private Trie find(String word) {
        Trie current = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                return null;
            }
            current = current.children[index];
        }
        return current;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }
}
