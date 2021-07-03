package com.prakash.leetcode.NewStart.Backtracking;

import java.util.LinkedList;
import java.util.Queue;

public class IteratorForCombination {

    public static void main(String[] args) {
        String str = "abcd";
        int length = 3;

        new CombinationIterator(str, length);

    }
}

class CombinationIterator {

    Queue<String> queue;

    public CombinationIterator(String characters, int combinationLength) {
        queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        processInput(characters, combinationLength, 0, sb);

    }

    public String next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public void processInput(String str, int length, int index, StringBuilder sb) {
        System.out.println("sb.length() " + sb.length());
        System.out.println("length " + length);
        if(length==0){
            System.out.println("sb.toString() ---> " + sb.toString());
            queue.offer(sb.toString());
            return;
        }
        for(int i=index;i<=str.length()-length;i++) {
            sb.append(str.charAt(i));
            processInput(str, length-1, i+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
