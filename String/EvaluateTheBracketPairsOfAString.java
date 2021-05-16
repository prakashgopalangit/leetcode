package com.prakash.leetcode.NewStart.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateTheBracketPairsOfAString {

    public static void main(String[] args) {
        String str = "(name)is(age)yearsold";
        List<List<String>> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("name");
        list1.add("bob");
        List<String> list2 = new ArrayList<>();
        list2.add("age");
        list2.add("two");
        list.add(list1);
        list.add(list2);
        System.out.println(" output --> " + new EvaluateTheBracketPairsOfAStringSolution().evaluate(str, list));
    }
}

class EvaluateTheBracketPairsOfAStringSolution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map = new HashMap<>();
        for(List<String> list : knowledge)
            map.put(list.get(0), list.get(1));
        int startIndex = 0;
        int endIndex = 0;
        boolean withinBrace = false;
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++){
            char c  = s.charAt(i);
            if(c=='(') {
                startIndex = i+1;
                withinBrace = true;
            }else if(c==')'){
                endIndex = i;
                String subStr = map.get(s.substring(startIndex, endIndex));
                sb.append(subStr!=null?subStr:"?");
                withinBrace = false;
            } else if(!withinBrace){
                sb.append(c);
            }

        }
        return sb.toString();
    }
}

