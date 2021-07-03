package com.prakash.leetcode.NewStart.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensII {

    public static void main(String[] args) {
        System.out.println( "result ---> " + new NQueensIISolution().totalNQueens(4));
        System.out.println( "result ---> " + new NQueensII_LeetcodeSolution().totalNQueens(4));

    }
}


class NQueensIISolution {
    int totalQueenPlacement;
    public int totalNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        if(n==1)
           return 1;
        int[][] board = new int[n][n];
        backtracking(board, list, 0, n, n);
        return totalQueenPlacement;
    }

    public void backtracking(int[][] board, List<List<String>> list, int i,  int n, int noOfQueens){
        if(noOfQueens==0)
            totalQueenPlacement++;
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


class NQueensII_LeetcodeSolution {
    int res = 0;
    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] di = new boolean[2*n];
        boolean[] anti = new boolean[2*n];
        dfs(0, col, di, anti, n);
        return res;
    }

    private void dfs(int index, boolean[] col, boolean[] di, boolean[] anti, int n) {
        if(index == n)  {
            System.out.println(" anti inside ---> "+ Arrays.toString(anti));
            res ++;
            return;
        }
        System.out.println(" ----------------------------- ");
        System.out.println(" col ---> "+ Arrays.toString(col));
        System.out.println(" di ---> "+ Arrays.toString(di));
        System.out.println(" anti ---> "+ Arrays.toString(anti));

        System.out.println(" index -----> "+ index);
        for(int i = 0; i<n; i++) {
            System.out.println(" i -----> "+ i);
            System.out.println(" i + index -----> "+ (i + index));
            System.out.println(" i - index + n -----> "+ (i - index + n));
            if(!col[i] && !di[i + index] && !anti[i - index + n]) {
                col[i] = true;
                di[i + index] = true;
                anti[i - index + n] = true;
                dfs(index + 1, col, di, anti, n);
                col[i] = false;
                di[i + index] = false;
                anti[i - index + n] = false;
            }
        }
    }
}