package com.prakash.leetcode.NewStart.Backtracking;

import java.util.*;

public class SynonymousSentences {

    public static void main(String[] args) {

        List<List<String>> synonyms = Arrays.asList(Arrays.asList("a","QrbCl"));
        String text = "d QrbCl ya ya NjZQ";
        List<String> result = new SynonymousSentencesSolution().generateSentences(synonyms, text);
        for(String str : result)
            System.out.println(str);
    }

}

class SynonymousSentencesSolution {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        List<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for(List<String> synonym : synonyms) {
            map.put(synonym.get(0), synonym.get(1));
            map.put(synonym.get(1), synonym.get(0));
        }
        backtracking(list, map, text );
        Collections.sort(list);
        return list;
    }

    public void backtracking(List<String> list, Map<String, String> map, String text){
        System.out.println(" ==================== ");
        System.out.println(" Actual String ---> "+ text);

            list.add(text);

        for(String str : text.split(" ")){
            StringBuilder stringBuilder = new StringBuilder();

            System.out.println("str ---> " + str);
            if(map.containsKey(str) && !list.contains(text.replaceAll(str, map.get(str)))){
                backtracking(list, map, text.replaceAll(str, map.get(str)));
            }
        }
    }
}
