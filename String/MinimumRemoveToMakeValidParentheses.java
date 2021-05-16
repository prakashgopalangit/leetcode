package com.prakash.leetcode.NewStart.String;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        String str = "(a(b(c)d)";
        System.out.println(" " + new MinimumRemoveToMakeValidParenthesesSolution().minRemoveToMakeValid(str));
    }
}


class MinimumRemoveToMakeValidParenthesesSolution{
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] goodOnes = new boolean[s.length()];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(')
                stack.push(i);
            else if(c==')'){
                if(!stack.isEmpty()){
                 goodOnes[i] = true;
                 goodOnes[stack.pop()] = true;
                }
            }else{
                goodOnes[i] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(goodOnes[i])
                sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
/*
class MinimumRemoveToMakeValidParenthesesSolution {
    public String minRemoveToMakeValid(String s) {
        String str = s;
        StringBuilder sb = new StringBuilder();
        boolean[] remove = new boolean[s.length()];
        int openBrace = 0;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='(')
                openBrace++;
            else if(c==')'){
                if(openBrace>0)
                    openBrace--;
                else
                    remove[i] = true;
            }
        }
        int closeBrace = 0;
        for(int i=str.length()-1;i>=0;i--){
            char c = str.charAt(i);
            if(c==')') {
                closeBrace++;
            }
            else if(c=='(') {
                if(closeBrace>0)
                    closeBrace--;
                else
                    remove[i] = true;
            }
        }
        for(int i=0;i<s.length();i++){
            if(!remove[i])
                sb.append(s.charAt(i));
        }

        return sb.toString();

    }


} */
