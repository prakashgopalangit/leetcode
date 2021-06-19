package com.prakash.leetcode.NewStart.TwoDimentionalArray;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIslandUsingQueue {

    public static void main(String[] args) {
        int[][] matrix = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(" maxAreaOfIsland --> " + new MaxAreaOfIslandUsingQueueSolution().maxAreaOfIsland(matrix));
    }
}


class MaxAreaOfIslandUsingQueueSolution{

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{0,-1},{-1,0},{0,1},{1,0}};
        int maxAreaLand  = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.println(" i value ---> "+ i);
                System.out.println(" j value ---> "+ j);
                System.out.println("grid[i][j] ---> "+ grid[i][j]);
                if(grid[i][j]==1 && !visited[i][j]){
                    System.out.println( " entering inside ");
                    int area = 0;
                    visited[i][j] = true;
                    queue.offer(new int[]{i,j});
                    System.out.println(" queue size() ---> "+ queue.size());
                    while(!queue.isEmpty()){
                        area++;
                        int[] cell = queue.poll();
                        int x = cell[0];
                        int y = cell[1];
                        for(int[] dir : dirs){
                            int newX = x + dir[0];
                            int newY = y + dir[1];
                            if(newX>=0 && newX<n && newY>=0 && newY<m && !visited[newX][newY] && grid[newX][newY]==1){
                                visited[newX][newY] = true;
                                queue.offer(new int[]{newX, newY});
                            }
                        }

                    }
                    if(area>maxAreaLand)
                        maxAreaLand = area;

                }

            }
        }
        return maxAreaLand;
    }
}