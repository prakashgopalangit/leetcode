package com.prakash.leetcode.NewStart.Trie;

import java.util.LinkedList;
import java.util.Queue;

class WordDictionary {
    TrieArray root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieArray();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieArray current = root;
        for(int i=0;i<word.length();i++){
            int charIndex = word.charAt(i)-'a';
            if(current.child[charIndex] == null){
                current.child[charIndex] = new TrieArray();
            }
            current = current.child[charIndex];
        }
        current.wordEnd = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchTrie(root, word, 0);
    }

    public boolean searchTrie(TrieArray root, String word, int index){
        if(index==word.length())
            return root.wordEnd;

        char c = word.charAt(index);

        if(c=='.'){ //Adding all child nodes, bcz we dont know which one has next character
            for(TrieArray trieArray : root.child) {
                if(trieArray!=null && searchTrie(trieArray, word, index+1)) {
                    return true;
                }
            }
        }else{
           return root.child[c-'a']!=null && searchTrie(root.child[c-'a'], word, index+1);
        }

        return false;
    }
}
