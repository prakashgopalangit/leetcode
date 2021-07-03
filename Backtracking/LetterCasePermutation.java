package com.prakash.leetcode.NewStart.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public static void main(String[] args) {
        String s = "a1b2";
        System.out.println("output --> " + new LetterCasePermutationSolution().letterCasePermutation(s));

    }
}

class LetterCasePermutationSolution {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        backtracking(list, S, 0);
        return list;
    }

    public void backtracking(List<String> list, String s, int index){
        list.add(s);
        for(int i=index;i<s.length();i++){
            if(Character.isLetter(s.charAt(i))){
                if(Character.isUpperCase(s.charAt(i)))
                    backtracking(list, s.substring(0,i)+Character.toLowerCase(s.charAt(i))+s.substring(i+1), i+1);
                else
                    backtracking(list, s.substring(0,i)+Character.toUpperCase(s.charAt(i))+s.substring(i+1), i+1);
            }

        }

    }
}
