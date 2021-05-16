package com.prakash.leetcode.NewStart.String;

import java.util.*;

public class WordBreakII {
    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> wordDict = Arrays.asList(new String[]{"apple","pen","applepen","pine","pineapple"});
        List<String > list = new WordBreakIISolution().wordBreak(s, wordDict);
        System.out.println(" printing output ---> "+ list);
    }
}

class WordBreakIISolution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        for(String word : wordDict)
            set.add(word);
        workBreakRecursion(s, set, list, sb);
        return list;
    }
    public void workBreakRecursion(String s, Set<String> wordDict, List<String> result, StringBuilder sb){
        System.out.println("---------------");
        System.out.println("s---> "+ s);
        if(s.length()==0 && sb.length()>0)
            result.add(sb.substring(0, sb.toString().length()-1));
        int start = 0;
        for(int i=0;i<s.length();i++){
            String str = s.substring(start, i+1);
            System.out.println("str--> "+ str);
            if(wordDict.contains(str)){
                sb.append(str);
                sb.append(" ");
                workBreakRecursion(s.substring(i+1, s.length()), wordDict, result, sb);
                System.out.println(" sb-->" + sb);
                sb.delete(sb.length()-str.length()-1, sb.length());
            }

        }
    }
}