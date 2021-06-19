package com.prakash.leetcode.NewStart.Trie;

import java.util.Arrays;

public class DesignAddAndSearchWordsDataStructure {

    public static void main(String[] args) {

        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        //System.out.println(" searching word ---> "+ wordDictionary.search(".at"));
        wordDictionary.addWord("bat");
        System.out.println(" searching word ---> "+ wordDictionary.search(".at"));
        //wordDictionary.addWord("dad");
        /*wordDictionary.addWord("mad");
        wordDictionary.addWord("pad");
        wordDictionary.addWord("bad");*/
        System.out.println("Arrays.toString(wordDictionary.root.child) ---> " + Arrays.toString(wordDictionary.root.child));
        //System.out.println(" searching word ---> "+ wordDictionary.search("a"));


    }
}
