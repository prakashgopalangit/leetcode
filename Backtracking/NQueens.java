package com.prakash.leetcode.NewStart.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static void main(String[] args) {
        System.out.println( "result ---> " + new NQueensSolution().solveNQueens(4));
    }
}


class NQueensSolution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        if(n==1){
            list.add(new ArrayList<>());
            list.get(0).add("Q");
            return list;
        }
        int[][] board = new int[n][n];
        backtracking(board, list, 0, n, n);
        return list;
    }

    public void backtracking(int[][] board, List<List<String>> list, int i,  int n, int noOfQueens){
        if(noOfQueens==0){
            List<String> newList = new ArrayList<>();
            for(int row=0;row<n;row++){
                StringBuilder sb = new StringBuilder();
                for(int col=0;col<n;col++){
                    if(board[row][col]==1){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                newList.add(sb.toString());
            }
            list.add(newList);
        }

        for(int k=0;k<n;k++){
            if(!isQueenUnderAttack(board, i, k)){
                board[i][k] = 1;
                backtracking(board, list, i+1, n, noOfQueens-1);
                board[i][k] = 0;
            }
        }
    }

    public boolean isQueenUnderAttack(int[][] board, int i, int j){
        for(int row=0;row<i;row++) {
            for (int col = 0; col < board.length; col++) {
                if(board[row][col]==1 && (col==j || Math.abs(i-row) == Math.abs(j-col)))
                    return  true;

            }
        }
        return false;

    }

}