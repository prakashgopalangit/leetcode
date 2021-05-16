package com.prakash.leetcode.NewStart.MicrosoftInterviewQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistance {

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "practice";
        System.out.println("shortest distance --> "+ new ShortestWordDistanceSolution().shortestDistance(words, word1, word2));
    }

}

class ShortestWordDistanceSolution{
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int word1Index = -1;
        int word2Index = -1;
        int shortDistance = Integer.MAX_VALUE;

        for(int i=0;i<wordsDict.length;i++){
            if(wordsDict[i].equalsIgnoreCase(word1))
                word1Index = i;
            if(wordsDict[i].equalsIgnoreCase(word2))
                word2Index = i;
            if(word1Index!=-1 && word2Index !=-1)
                shortDistance = Math.min(shortDistance, Math.abs(word1Index-word2Index));
        }

        return shortDistance;
    }
}



//Not better performance
/*class ShortestWordDistanceSolution{
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        int i=0;
        int shortDistance = Integer.MAX_VALUE;
        for(String word : wordsDict){
            List<Integer> list = map.getOrDefault(word, new ArrayList<>());
            list.add(i++);
            map.put(word, list);
        }
        for(Integer word1Index : map.get(word1)){
            for(Integer word2Index : map.get(word2)){
                shortDistance = Math.min(shortDistance, Math.abs(word1Index-word2Index));
            }
        }
        return shortDistance;
    }
}*/