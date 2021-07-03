package com.prakash.leetcode.NewStart.Backtracking;

import java.util.*;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {

    public static void main(String[] args) {
        //List<String> arr = Arrays.asList("abc","d","efg","chijk","bwxyz");
        List<String> arr = Arrays.asList("yy","bkhwmpbiisbldzknpm");

        System.out.println(" maxLength ---> "+ new MaximumLengthOfAConcatenatedStringWithUniqueCharactersSolution().maxLength(arr));
    }

}

class MaximumLengthOfAConcatenatedStringWithUniqueCharactersSolution {
    int maxLength;
    public int maxLength(List<String> arr) {
        if(arr.size()==1) return arr.get(0).length();
        for(int i=0;i<arr.size();i++){
            System.out.println("arr.get(i) starting --->  " + arr.get(i) );
            if(containsUnique(arr.get(i)))
                dfs(arr, arr.get(i), i);
        }
        return maxLength;
    }

    public void dfs(List<String> arr, String str, int index){
        for(int i=index+1;i<arr.size();i++){
           if(containsUnique(str+arr.get(i)))
               dfs(arr, str+arr.get(i), i);
        }
        System.out.println(" str ---> "+ str);
        maxLength = Math.max(str.length(), maxLength);
    }

    public boolean containsUnique(String s){
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            if (++cnt[c - 'a'] > 1) return false;
        }
        return true;
    }
}
