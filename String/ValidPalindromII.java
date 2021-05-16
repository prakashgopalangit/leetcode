package com.prakash.leetcode.NewStart.String;

public class ValidPalindromII {
    public static void main(String[] args) {
        String str = "abca";
        System.out.println(" boolean value --> " + new ValidPalindromIISolution().validPalindrome(str));
    }
}

class ValidPalindromIISolution{
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
              return isPalindrome(start+1, end, s) || isPalindrome(start, end-1, s);
            }
            start++;
            end--;
        }
       return true;
    }

    public boolean isPalindrome(int startIndex, int endIndex, String s){
        System.out.println("going inside to check ");
        while(startIndex<endIndex){
            System.out.println("s.charAt(startIndex) " + s.charAt(startIndex));
            System.out.println("s.charAt(endIndex) " + s.charAt(endIndex));
            if(s.charAt(startIndex)!=s.charAt(endIndex)){
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }
}
