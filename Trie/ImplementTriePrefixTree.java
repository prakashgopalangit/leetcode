package com.prakash.leetcode.NewStart.Trie;

import java.util.Map;

public class ImplementTriePrefixTree {

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("abc");
        printTrieNode(trie.root);
        System.out.println("trie.search(\"abc\") ---> " + trie.search("abc"));
        System.out.println("trie.search(\"a\") ---> " + trie.search("a"));
        System.out.println("trie.search(\"ac\") ---> " + trie.search("ac"));

        System.out.println("trie.startsWith(\"ac\") ---> " + trie.startsWith("a"));
        System.out.println("trie.startsWith(\"abc\") ---> " + trie.startsWith("abc"));
        System.out.println("trie.startsWith(\"ae\") ---> " + trie.startsWith("ae"));

    }

    public static void printTrieNode(TrieNode root){
        if(root.map.size()>0){
            for(Map.Entry<Integer, TrieNode> entry : root.map.entrySet()){
                System.out.println("entry.getKey() --> " + entry.getKey());
                System.out.println("entry.getValue().wordEnd ---> " + entry.getValue().wordEnd);
                System.out.println("entry.getValue().prefixCount ---> " + entry.getValue().prefixCount);
                printTrieNode(entry.getValue());
            }
        }

    }

}


