package com.prakash.leetcode.NewStart.String;

import java.util.Arrays;

public class TruncateSentence {

    public static void main(String[] args) {
        String str = "chopper is not a tanuki";
        System.out.println(" output --> "+ new TruncateSentenceSolution().truncateSentence(str, 5));
        System.out.println(" output --> "+ new TruncateSentenceSolution().truncateSentenceBetter(str, 5));
    }

}

class TruncateSentenceSolution{
    public String truncateSentence(String s, int k) {
        if(s.indexOf(' ')<0)
            return s;
        StringBuilder sb = new StringBuilder();
        String[] words = s.split("\\s+");
        int i = 0;
        int max = k;
        while(max>0){
            sb.append(words[i++]);
            sb.append(" ");
            max--;
        }
        return sb.toString().substring(0, sb.toString().length()-1);
    }
    public String truncateSentenceBetter(String s, int k) {
        if(s.indexOf(' ')<0)
            return s;
        int endIndex = s.length();
        int spaceCount = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ')
                spaceCount++;
            if(spaceCount==k) {
                endIndex = i;
                break;
            }

        }
        return s.substring(0, endIndex);
    }

}
