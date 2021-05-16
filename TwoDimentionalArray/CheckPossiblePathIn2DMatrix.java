package com.prakash.leetcode.NewStart.TwoDimentionalArray;

//https://leetcode.com/discuss/interview-question/241889/Google-or-Check-for-possible-path-in-2D-matrix

public class CheckPossiblePathIn2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 0, 1, 0},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 1, 0},
                {1, 0, 1, 9, 1},
                {1, 0, 1, 0, 1}};
        int rLength = matrix.length;
        int cLength = matrix[0].length;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        boolean result = checkPath(matrix, visited, 0, 0 , rLength, cLength);
        System.out.println(" output result ---> " + result);
    }


    public static boolean checkPath(int[][] matrix, boolean[][] visited, int row, int col, int rLength, int cLength){
        if(!(row<rLength && col<cLength && row>=0 && col >= 0))
            return false;
        if(visited[row][col] || matrix[row][col]==0)
            return false;
        visited[row][col]=true;

        if(matrix[row][col]==9)
            return true;

        return checkPath(matrix, visited, row-1, col, rLength, cLength)
                || checkPath(matrix, visited, row+1, col, rLength, cLength)
                ||  checkPath(matrix, visited, row, col-1, rLength, cLength)
                ||  checkPath(matrix, visited, row, col+1, rLength, cLength);
    }

}


