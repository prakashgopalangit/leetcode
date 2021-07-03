package com.prakash.leetcode.NewStart.Backtracking;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LetterTilePossibilities {

    public static void main(String[] args) {

        System.out.println(" result ---> "+ new LetterTilePossibilitiesSolution().numTilePossibilities("AAB"));

    }
}

class LetterTilePossibilitiesSolution{
    int count;
    public int numTilePossibilities(String tiles) {
       backTracking(tiles, 0, new StringBuilder());
       return count;
    }
    public void backTracking(String tiles, int index, StringBuilder sb){
       if(sb.length()>0) {
           System.out.println( "sb --> "+ sb.toString());
           count++;
       }
       for(int i=0;i<tiles.length();i++){
           sb.append(tiles.charAt(i));
           backTracking(tiles,i+1, sb);
           sb.deleteCharAt(sb.length()-1);
       }
    }
}
