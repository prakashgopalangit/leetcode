package com.prakash.leetcode.NewStart.Graph;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class SurroundedRegions {

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        new SurroundedRegionsSolution().solve(board);
        System.out.println(" board -->" + Arrays.deepToString(board));
    }

}

class SurroundedRegionsSolution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        //process top and bottom rows
        for(int i=0;i<m;i++){

            System.out.println("i-->0"+ " j-->"+i);
            borderCheck(board, 0, i);
            System.out.println("i-->"+ (n-1) + " j-->"+i);
            borderCheck(board, n-1, i);
        }

        //process first and last columns
        for(int i=0;i<n;i++){
            borderCheck(board, i, 0);
            borderCheck(board, i, m-1);
        }

        System.out.println(" board inside ---> "+ Arrays.deepToString(board));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O')
                    board[i][j] = 'X';
                if(board[i][j]=='*')
                    board[i][j] = 'O';
            }
        }


    }


    public void borderCheck(char[][] board, int i, int j){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!='O')
            return;

        board[i][j] = '*';

        borderCheck(board, i+1, j);
        borderCheck(board, i-1, j);
        borderCheck(board, i, j+1);
        borderCheck(board, i, j-1);
    }

}
