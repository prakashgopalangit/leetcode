package com.prakash.leetcode.NewStart.String;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        String str = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");

        System.out.println(" boolean value --> "+ new WordBreakSolution().wordBreak(str, wordDict));
    }
}

//DP solution
class WordBreakSolution {
    public boolean wordBreak(String s, List<String> dict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for(int i=1; i <= s.length(); i++){
            System.out.println(" i --> "+ i);
            for(int j=0; j < i; j++){
                System.out.println(" j --> "+ j);
                System.out.println(" s.substring(j, i) --> " + s.substring(j, i));
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
            System.out.println(" f value --> " + Arrays.toString(f));
        }
        return f[s.length()];
    }
}

//substring solution
/*class WordBreakSolution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> cache = new HashMap<>();
        return wordBreakHelper(s, wordDict, cache);
    }

    public boolean wordBreakHelper(String s, List<String> wordDict, Map<String, Boolean> cache){
        if(cache.containsKey(s)) return cache.get(s);
        if(wordDict.contains(s)) return true;
        for(int i=1;i<s.length();i++){
            if(wordDict.contains(s.substring(0,i)) && wordBreakHelper(s.substring(i, s.length()),wordDict, cache)){
                cache.put(s, true);
                return true;
            }
        }
        cache.put(s, false);
        return false;
    }

}*/

