package com.prakash.leetcode.NewStart.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        String digits = "234";
        System.out.println(" digit combinations --> " + new LetterCombinationsOfAPhoneNumberSolution().letterCombinations(digits));
    }

}

class LetterCombinationsOfAPhoneNumberSolution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length()==0) return result;
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtracking(0, new StringBuilder(), digits, result, map);
        return result;
    }

    public void backtracking(int index, StringBuilder sb, String digits, List<String> list, Map<Character, String> map){
        if(sb.length()==digits.length()) {
            list.add(sb.toString());
            return;
        }
        String str = map.get(digits.charAt(index));
        for(int i=0; i<str.length();i++){
            sb.append(str.charAt(i));
            backtracking(index+1, sb, digits, list, map);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
