package com.prakash.leetcode.NewStart.String;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static void main(String[] args) {
        String str = "ccc";
        System.out.println(" longestPalindrome--> " + new LongestPalindromeSolution().longestPalindrome(str));
    }
}

class LongestPalindromeSolution {
    public int longestPalindrome(String s) {
        if(s.length()==1) return 1;
        int longestPalindrome=0;
        boolean anySingleCharacter = false;
        int[] charArray = new int[128];
        for(int i=0;i<s.length();i++)
            charArray[s.charAt(i)]++;

        System.out.println(" printing charArray --> "+ charArray);
        for(int val:charArray){
            System.out.println("val--> " + val);
            longestPalindrome += val/2*2;
            val = val%2;
            if(val>0){
                anySingleCharacter = true;
            }
        }
        return anySingleCharacter==true?longestPalindrome+1:longestPalindrome;
    }
}