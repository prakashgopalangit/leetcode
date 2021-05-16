package com.prakash.leetcode.NewStart.String;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String str = "a";
        System.out.println(" longest palindrome --> " + new LongestPalindromicSubstringSolution().longestPalindrome(str));

    }
}

class LongestPalindromicSubstringSolution {
    int longestStartIndex;
    int longestLength;
    public String longestPalindrome(String s) {
        if(s.length()<=1) return s;

        for(int i=0;i<s.length()-1;i++){
            System.out.println(" i value --> " + i);
            expandRange(s, i, i);
            expandRange(s, i, i+1);
            System.out.println(" ==================== "  );
        }
        return s.substring(longestStartIndex, longestStartIndex+longestLength);
    }
    public void expandRange(String str, int start, int end){
        while(start>=0 && end< str.length() && str.charAt(start)==str.charAt(end)){
            start--;
            end++;
        }
        if(longestLength < end-start-1){
            longestStartIndex=start+1;
            longestLength = end-start-1;
        }

    }

}
