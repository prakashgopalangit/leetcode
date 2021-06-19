package com.prakash.leetcode.NewStart.TwoDimentionalArray;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] matrix = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(" maxAreaOfIsland --> " + new MaxAreaOfIslandSolution().maxAreaOfIsland(matrix));
    }
}


class MaxAreaOfIslandSolution {
    int maxArealand = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        boolean[][] visited = new boolean[rowLength][colLength];
        for(int row=0;row<rowLength;row++){
            for(int col=0;col<colLength;col++){
                if(grid[row][col]==1){
                    dfs(grid, row, col, visited);
                }
            }
        }
        return maxArealand;
    }

    public int dfs(int[][] grid, int row, int col, boolean[][] visited){
        System.out.println("row -->  "+ row);
        System.out.println("col -->  "+ col);
        if(row<0 || row>=grid.length || col<0 || col >=grid[0].length)
            return 0;
        if(grid[row][col]==0 || visited[row][col])
            return 0;
        visited[row][col] = true;
        int localAreaLand = 1 + dfs(grid, row+1, col, visited)
                            + dfs(grid, row-1, col, visited)
                            + dfs(grid, row, col+1, visited)
                            + dfs(grid, row, col-1, visited);
        this.maxArealand = Math.max(maxArealand, localAreaLand);
        return localAreaLand;
    }
}