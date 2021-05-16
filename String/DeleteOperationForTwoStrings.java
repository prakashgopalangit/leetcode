package com.prakash.leetcode.NewStart.String;

public class DeleteOperationForTwoStrings {

    public static void main(String[] args) {
        String word1 = "leetcode";
        String word2 = "etco";

        System.out.println(" minimum distance --> "+ new DeleteOperationForTwoStringsSolution().minDistance(word1, word2));
    }

}
class DeleteOperationForTwoStringsSolution {
    public int minDistance(String word1, String word2) {
        if(word1.equalsIgnoreCase(word2)) return 0;
        return findMinDistance(word1, word2, 0, 0);
    }

    public int findMinDistance(String word1, String word2, int i, int j){
        if(i>=word1.length() || j >= word2.length())
            return 0;

        if(word1.charAt(i)==word2.charAt(j)){
            return 1+findMinDistance(word1, word2, i+1,j+1);
        }else{
            return Math.max(findMinDistance(word1, word2, i+1, j), findMinDistance(word1, word2, i,j+1));
        }

    }

}