package com.prakash.leetcode.NewStart.String;

import java.util.*;

public class LongestValidParentheses {


    public static void main(String[] args) {
        //String str = ")()())";
        String str = "(((()";
        System.out.println(" return val --> " + new LongestValidParenthesesSoluition().longestValidParentheses(str));
    }
}

class LongestValidParenthesesSoluition{
    public int longestValidParentheses(String s) {
        int left=0;
        int right=0;
        int maxValidParanthesis = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                left++;
            if(s.charAt(i)==')')
                right++;
            if(left==right)
                maxValidParanthesis = Math.max(maxValidParanthesis, 2*left);
            else if(right>=left){
                left = right = 0;
            }
        }
        left = right = 0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='(')
                left++;
            if(s.charAt(i)==')')
                right++;
            if(left==right)
                maxValidParanthesis = Math.max(maxValidParanthesis, 2*left);
            else if(left>=right){
                left = right = 0;
            }
        }
        return maxValidParanthesis;
    }
}
