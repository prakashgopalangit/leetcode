package com.prakash.leetcode.NewStart.Trie;


class Trie {
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            TrieNode child = current.map.getOrDefault((word.charAt(i)-'a'), new TrieNode());
            child.prefixCount += 1;
            current.map.put((word.charAt(i)-'a'), child);
            current = child;
        }
        current.wordEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            TrieNode child =  current.map.get(word.charAt(i)-'a');
            if(child==null)
                return false;
            current = child;
        }
        return current.wordEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i=0;i<prefix.length();i++){
            TrieNode child =  current.map.get(prefix.charAt(i)-'a');
            if(child==null)
                return false;
            current = child;
        }
        return current.prefixCount>0;
    }
}


