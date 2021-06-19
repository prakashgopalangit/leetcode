package com.prakash.leetcode.NewStart.Trie;

import java.util.*;

public class DesignSearchAutocompleteSystem {

    public static void main(String[] args) {
        String[] sentences = {"abc", "abbc", "a"};
        int[] times = {3,3,3};
        AutocompleteSystem autocompleteSystem = new AutocompleteSystem(sentences, times);
        System.out.println(" result ---> "+ autocompleteSystem.input('b'));
        System.out.println(" result ---> "+ autocompleteSystem.input('c'));
        System.out.println(" result ---> "+ autocompleteSystem.input('#'));
        System.out.println(" result ---> "+ autocompleteSystem.input('b'));
        System.out.println(" result ---> "+ autocompleteSystem.input('c'));
        System.out.println(" result ---> "+ autocompleteSystem.input('#'));
        System.out.println(" result ---> "+ autocompleteSystem.input('a'));
        System.out.println(" result ---> "+ autocompleteSystem.input('b'));
        System.out.println(" result ---> "+ autocompleteSystem.input('c'));
        System.out.println(" result ---> "+ autocompleteSystem.input('#'));
        System.out.println(" result ---> "+ autocompleteSystem.input('a'));
        System.out.println(" result ---> "+ autocompleteSystem.input('b'));
        System.out.println(" result ---> "+ autocompleteSystem.input('c'));
        System.out.println(" result ---> "+ autocompleteSystem.input('#'));



    }


}


class AutocompleteSystem{

    TrieMap root;
    String currentString="";
    PriorityQueue<String[]> pq;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieMap();
        pq = new PriorityQueue<String[]>(new SearchCompare());
        buildTrie(sentences, times);
    }

    public List<String> input(char c) {
        if(c=='#') {
            addNewStringToTrie(currentString, 1);
            currentString="";
            return new ArrayList<>();
        }else{
            currentString = currentString + c;
            collectAllStrings(currentString);
            List<String> results = new ArrayList<>();
            int i = 0;
            while(!pq.isEmpty()){
                String[] node = pq.poll();
                //System.out.println(" node[0] ---> " + node[0]);
                if(i<3){

                    results.add(node[0]);
                    i++;
                }
            }
            return results;
        }
    }

    public void collectAllStrings(String currentString){
        TrieMap current = root;
        for(char c : currentString.toCharArray()){
            if(!current.child.containsKey(c))
                return;
            current = current.child.get(c);
        }

        Queue<TrieMap> queue = new LinkedList<>();
        queue.offer(current);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TrieMap node = queue.poll();
                if(node.wordEnd){
                    //System.out.println("node.str --->  " + node.str);
                    //System.out.println("node.times --->  " + node.times);
                    pq.offer(new String[]{node.str, String.valueOf(node.times)});
                }
                for(Map.Entry<Character, TrieMap> entry : node.child.entrySet()){
                    if(entry.getValue()!=null){
                        queue.offer(entry.getValue());
                    }
                }

            }
        }
    }

    public void buildTrie(String[] sentences, int[] times){
        for(int i=0;i<sentences.length;i++){
            TrieMap current = root;
            for(char c : sentences[i].toCharArray()){
                TrieMap node = current.child.getOrDefault(c, new TrieMap());
                current.child.put(c, node);
                current = node;
            }
            current.wordEnd = true;
            current.str = sentences[i];
            current.times = times[i];
        }
    }

    public void addNewStringToTrie(String newString, int times){
        TrieMap current = root;
        for(char c : newString.toCharArray()){
            TrieMap node = current.child.getOrDefault(c, new TrieMap());
            current.child.put(c, node);
            current = node;
        }
        current.wordEnd = true;
        current.str = newString;
        current.times = current.times+times;
    }
}

class SearchCompare implements Comparator<String[]>{
    public int compare(String[] a, String[] b){
        if(Integer.parseInt(a[1])!=Integer.parseInt(b[1]))
            return Integer.parseInt(b[1]) - Integer.parseInt(a[1]);
        else
            return a[0].compareTo(b[0]);
    }
}


class TrieMap{
    Map<Character, TrieMap> child;
    boolean wordEnd;
    String str;
    int times;

    TrieMap(){
        this.child = new HashMap<>();
        this.wordEnd = false;
        this.str = "";
        this.times = 0;
    }


}