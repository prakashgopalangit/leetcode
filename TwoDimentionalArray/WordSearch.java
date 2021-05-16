package com.prakash.leetcode.NewStart.TwoDimentionalArray;

public class WordSearch {
    public static void main(String[] args) {
        char[][] charArray = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String word ="ABCESEEEFS";
        System.out.println(" output is --> " + new WordSearchSolution().exist(charArray, word));

    }

}

class WordSearchSolution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(word.length()==1 || foundWord(board, i, j, word, 0))
                        return true;
                }

            }
        }
        return false;
    }

    public boolean foundWord(char[][] board, int row, int col, String word, int charIndex){
        if(row<0 || col<0 || row>=board.length || col>=board[0].length || board[row][col]=='0' ||  word.charAt(charIndex) != board[row][col] || charIndex>=word.length())
            return false;
        if(charIndex== word.length()-1)
            return true;
        char temp = board[row][col];
        board[row][col] = '0';
        if(foundWord(board, row+1, col, word, charIndex+1) ||
                foundWord(board, row-1, col, word, charIndex+1) ||
                foundWord(board, row, col+1, word, charIndex+1) ||
                foundWord(board, row, col-1, word, charIndex+1)){
            return true;
        }
        board[row][col] =  temp;
        return false;
    }
}
