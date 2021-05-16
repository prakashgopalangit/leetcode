package com.prakash.leetcode.NewStart.String;

public class LongestSubstringWithAtLeastKRepeatingCharacters {

    public static void main(String[] args) {
        String str = "ababbc";
        System.out.println(" longest substring length --> " + new LongestSubstringWithAtLeastKRepeatingCharactersSolution().longestSubstring(str, 3));
    }
}

class LongestSubstringWithAtLeastKRepeatingCharactersSolution{
    public int longestSubstring(String s, int k) {
        int[] countArray = new int[26];
        int longestSubstring = 0;
        for(char c : s.toCharArray())
            countArray[c-'a']++;
        int badChar = -1;
        for(int i=0;i<s.length();i++){
            if(countArray[s.charAt(i)-'a']<k){
                badChar = i;
                break;
            }
        }
        if(badChar==-1) return s.length();
        int left = longestSubstring(s.substring(0, badChar), k);
        int right = longestSubstring(s.substring(badChar+1, s.length()), k);
        longestSubstring = Math.max(longestSubstring, Math.max(left, right));
        return longestSubstring;
    }
}