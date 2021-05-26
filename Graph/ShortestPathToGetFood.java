package com.prakash.leetcode.NewStart.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToGetFood {

    public static void main(String[] args) {
        char[][] grid = {{'X','X','X','X','X','X','X','X'},{'X','*','O','X','O','#','O','X'},{'X','O','O','X','O','O','X','X'},{'X','O','O','O','O','#','O','X'},{'X','X','X','X','X','X','X','X'}};
        System.out.println(" shortestPath ---> "+ new ShortestPathToGetFoodSolution().getFood(grid));
    }

}

class ShortestPathToGetFoodSolution {
    public int getFood(char[][] grid) {
        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
        int[] startingIndices = {0,0};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int shortestPath = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='*'){
                    startingIndices[0] = i;
                    startingIndices[1] = j;
                    break;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        System.out.println("startingIndices --> "+ Arrays.toString(startingIndices));
        queue.offer(startingIndices);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int j=0;j<size;j++) {
                int[] pair = queue.poll();
                int x = pair[0];
                int y = pair[1];
                if(x<0 || y<0 || x>=grid.length || y>=grid[x].length || grid[x][y]=='X' || visited[x][y])
                    continue;
                if (grid[x][y] == '#')
                    return shortestPath;
                for (int[] direction: dirs) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];
                    queue.offer(new int[]{newX, newY});
                    visited[x][y] = true;
                }
                grid[x][y] = 'X';
            }
            shortestPath++;
        }
        return -1;
    }

}
