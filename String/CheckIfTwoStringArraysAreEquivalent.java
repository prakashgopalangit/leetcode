package com.prakash.leetcode.NewStart.String;

public class CheckIfTwoStringArraysAreEquivalent {

    public static void main(String[] args) {
        String[] word1 = {"abc", "d", "defg"};
        String[] word2 = {"abcddefg"};
        System.out.println(" output ---> "+ new CheckIfTwoStringArraysAreEquivalentSolution().arrayStringsAreEqual(word1, word2));
    }

}

class CheckIfTwoStringArraysAreEquivalentSolution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        StringBuilder sb = new StringBuilder();
        for(String word : word1){
            sb.append(word);
        }
        String str = sb.toString();
        System.out.println(" str --> "+ str);
        int i =0;
        for(String word : word2){
            if(word.length()>str.length())
                return false;
            if(!str.substring(i, word.length()).equalsIgnoreCase(word))
                return false;
            else{
                str = str.substring(word.length());
            }
        }
        System.out.println(" output string --> "+ str);
        return str.length()>0?false:true;

    }
}
