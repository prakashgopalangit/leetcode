package com.prakash.leetcode.NewStart.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {

    public static void main(String[] args) {
        String currentState = "++++";
        System.out.println(" return list ---> "+ new FlipGameSolution().generatePossibleNextMoves(currentState));


    }
}

class FlipGameSolution {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> list = new ArrayList<>();
        char[] charArray = currentState.toCharArray();
        for(int i=0;i<charArray.length-1;i++){
            System.out.println("currentState.substring(i, i+2) -->  " + currentState.substring(i, i+2));
            if(charArray[i]=='+' && charArray[i+1]=='+'){
                System.out.println(" currentState.substring(i,i+1)+\"--\"+currentState.substring(i+2, currentState.length()) "+ currentState.substring(0,i)+"--"+currentState.substring(i+2, currentState.length()));
                list.add(currentState.substring(0,i)+"--"+currentState.substring(i+2, currentState.length()));
            }
        }
        return list;
    }

}
