package com.prakash.leetcode.NewStart.Trie;

public class LongestWordInDictionary {

    public static void main(String[] args) {
        String[] words = {"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
        System.out.println(" longestWord ---> "+ new LongestWordInDictionarySolution().longestWord(words));
    }


}

class LongestWordInDictionarySolution {
    public String longestWord(String[] words) {
        TrieArray root = new TrieArray();
        for(String word : words)
            buildTrieTree(root, word);
        return findLongestWord(root);
    }

    public void buildTrieTree(TrieArray root, String word){
        TrieArray current = root;
        System.out.println(" word ---> "+ word);
        for(int i=0;i<word.length();i++){
            System.out.println(" current.child[word.charAt(i)-'a'] BEFORE ---> " + current.child[word.charAt(i)-'a']);
            if(current.child[word.charAt(i)-'a']==null)
                current.child[word.charAt(i)-'a'] = new TrieArray();
            System.out.println(" current.child[word.charAt(i)-'a'] ---> " + current.child[word.charAt(i)-'a']);
            System.out.println(" current.child[word.charAt(i)-'a'].wordEnd ---> " + current.child[word.charAt(i)-'a'].wordEnd);
            current = current.child[word.charAt(i)-'a'] ;
        }
        current.wordEnd=true;
    }


    public String findLongestWord(TrieArray root){
        String str = "";
        for(int i=0;i<root.child.length;i++) {
            System.out.println(" root.child[i] ---> " + root.child[i]);
            if (root.child[i] != null) {
                if(root.child[i].wordEnd){
                    String internalString = (char)(i + 'a') + findLongestWord(root.child[i]);
                    System.out.println(" internalString --> " + internalString);
                    if (internalString.length() > str.length() && internalString.compareTo(str)>0) {
                        str = internalString;
                    }
                }
            }
        }
        return str;
    }
}




