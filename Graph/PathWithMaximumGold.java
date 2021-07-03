package com.prakash.leetcode.NewStart.Graph;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class PathWithMaximumGold {

    public static void main(String[] args) {
        //int[][] grid = {{3,6,9,4,5},{4,0,2,0,0},{0,0,0,0,0},{10,0,0,40,20},{35,0,0,75,0}};
        int[][] grid = {{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}};
        System.out.println(" maxGold ---> "+ new PathWithMaximumGoldSolution().getMaximumGold(grid));
    }

}
class PathWithMaximumGoldSolution {

    int maxGold = 0;
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0){
                    int subMax = dfs(grid, i, j, visited);
                    System.out.println(" subMax ---> "+ subMax);
                    maxGold = Math.max(maxGold, subMax);
                }
            }
        }
        return maxGold;
    }

    public int dfs(int[][] grid, int i, int j, boolean[][] visited){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j] || grid[i][j]==0)
            return 0;
        System.out.println(" grid[i][j] INSIDE ---> "+ grid[i][j]);
        visited[i][j] = true;
        int subMax = grid[i][j] + Math.max(
                            dfs(grid, i,j-1, visited ), Math.max(
                                    dfs(grid, i,j+1, visited ),Math.max(dfs(grid, i-1,j, visited ), dfs(grid, i+1,j, visited ))));
        visited[i][j] = false;
        return subMax;
    }
}