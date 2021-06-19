package com.prakash.leetcode.NewStart.Trie;

import java.util.HashMap;
import java.util.Map;

public class PrefixAndSuffixSearch {

    public static void main(String[] args) {
        //String[] words = {"hello","hllo","hallo","hacllo","habhllo"};
        String[] words = {"cabaabaaaa","ccbcababac","bacaabccba","bcbbcbacaa","abcaccbcaa","accabaccaa","cabcbbbcca","ababccabcb","caccbbcbab","bccbacbcba"};

        WordFilter wordFilter = new WordFilter(words);
        System.out.println(" prefixSuffixWordIndex  " + wordFilter.f("bccbacbcba","a"));
        System.out.println(" prefixSuffixWordIndex  " + wordFilter.f("ab","abcaccbcaa"));
        System.out.println(" prefixSuffixWordIndex  " + wordFilter.f("a","aa"));
        System.out.println(" prefixSuffixWordIndex  " + wordFilter.f("cabaaba","abaaaa"));
        System.out.println(" prefixSuffixWordIndex  " + wordFilter.f("cacc","accbbcbab"));
        System.out.println(" prefixSuffixWordIndex  " + wordFilter.f("ccbcab","bac"));
        System.out.println(" prefixSuffixWordIndex  " + wordFilter.f("bac","cba"));
        System.out.println(" prefixSuffixWordIndex  " + wordFilter.f("ac","accabaccaa"));
        System.out.println(" prefixSuffixWordIndex  " + wordFilter.f("bcbb","aa"));
        System.out.println(" prefixSuffixWordIndex  " + wordFilter.f("ccbca","cbcababac"));

    }

}

class WordFilter {
    TrieArray root;
    Map<String, Integer> stringIndexMap = new HashMap<>();
    StringBuilder sb = new StringBuilder();

    public WordFilter(String[] words) {
        root = new TrieArray();
        int index = 0;
        for(String str : words){
            stringIndexMap.put(str, index++);
            TrieArray current = root;
            for(int i=0;i<str.length();i++){
              if(current.child[str.charAt(i)-'a'] == null)
                  current.child[str.charAt(i)-'a'] = new TrieArray();
              current = current.child[str.charAt(i)-'a'];
            }
            current.wordEnd = true;
        }
    }

    public int f(String prefix, String suffix) {
        TrieArray current = root;
        for(int i=0;i<prefix.length();i++){
            TrieArray child = current.child[prefix.charAt(i)-'a'];
            if(child==null)
                return -1;
            sb.append(prefix.charAt(i));
            current = child;
        }
        System.out.println(" sb.toString() after prefix " + sb.toString());
        String suffixString = backtrack(current, suffix, 0, new StringBuilder());
        System.out.println("suffixString --> " + suffixString);
        if(suffixString=="" && !sb.toString().endsWith(suffix))
            return -1;
        sb.append(suffixString);
        System.out.println("sb after prefix --> " + sb);

        return stringIndexMap.get(sb.toString())!=null?stringIndexMap.get(sb.toString()):-1;
    }

    public String backtrack(TrieArray current, String suffix, int index, StringBuilder sb){
        String str = "";

        System.out.println(" sb.toString() " + sb.toString());
        if(current.wordEnd && sb.toString().endsWith(suffix)){
            if(sb.toString().length()>str.length()){
                str = sb.toString();
            }
        }
        for(int i=0;i<current.child.length;i++){
            if(current.child[i]!=null){
                sb.append((char) (i+'a'));
                String s = backtrack(current.child[i], suffix, index+1, sb);
                if(s.length()>str.length()){
                    str = s;
                }
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return str;
    }
}


