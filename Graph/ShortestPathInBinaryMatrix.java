package com.prakash.leetcode.NewStart.Graph;

public class ShortestPathInBinaryMatrix {


    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{0,0,0},{0,1,0}};
        //System.out.println(" shortest path -->" + new ShortestPathInBinaryMatrixSolution().shortestPathBinaryMatrix(grid) );


    }
}


/*class ShortestPathInBinaryMatrixSolution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0]!=0 || grid[n-1][n-1] !=0)
            return -1;
        int min = dfs(grid, 0, 0);
        System.out.println(" min --> "+ min);
        return min==Integer.MAX_VALUE?-1:min;
    }

    public int dfs(int[][] grid, int i, int j){
        if(i>=grid.length || i<0 || j>= grid.length || j<0 || grid[i][j]==1)
            return Integer.MAX_VALUE;
        if(i==grid.length-1 && j==grid.length-1)
            return 1;

        int mathMin = 0
        int mathMin =
                Math.min(dfs(grid, i-1, j-1),(
        Math.min(dfs(grid, i-1, j),(
        Math.min(dfs(grid, i-1, j+1),(
        Math.min(dfs(grid, i, j+1),(
        Math.min(dfs(grid, i, j-1),(
        Math.min(dfs(grid, i+1, j-1),(
        Math.min(dfs(grid, i+1, j),
        dfs(grid, i+1, j+1);

        return mathMin==Integer.MAX_VALUE?mathMin:mathMin+1;
    }
}*/