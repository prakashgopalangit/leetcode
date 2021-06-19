package com.prakash.leetcode.NewStart.Trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode{
    //int[] childNodes;
    Map<Integer, TrieNode> map;
    boolean wordEnd;
    int prefixCount;

    TrieNode(){
        //childNodes = new int[26];
        map = new HashMap<>();
        wordEnd = false;
        prefixCount = 0;
    }
}
