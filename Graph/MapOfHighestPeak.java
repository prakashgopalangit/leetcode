package com.prakash.leetcode.NewStart.Graph;

import java.util.Arrays;

public class MapOfHighestPeak {

    public static void main(String[] args) {
        int[][] isWater = {{0,1},{0,0}};
        System.out.println(" return Array ---> "+ Arrays.deepToString(new MapOfHighestPeakSolution().highestPeak(isWater)));


    }

}
class MapOfHighestPeakSolution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        //Marking nearby land with 1 for a water land
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isWater[i][j]==1){
                    markNeighbor(isWater, i, j, dirs);
                }
            }
        }
        System.out.println(" first step array ---> "+ Arrays.deepToString(isWater));

        boolean[][] visited = new boolean[n][m];
        //perform BFS to fill array
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isWater[i][j]!=-1 && isWater[i][j]!=0){
                    incrementNeighbor(isWater, i, j, dirs, visited);
                }
            }
        }

        System.out.println(" second step array ---> "+ Arrays.deepToString(isWater));

        //change water from -1 to 0
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isWater[i][j]==-1)
                    isWater[i][j]=0;
                else if(isWater[i][j]!=0)
                    isWater[i][j] = isWater[i][j]-1;

            }
        }

        return isWater;
    }

    public void markNeighbor(int[][] isWater, int i, int j, int[][] dirs){
        isWater[i][j] = -1;
        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            if(isValid(isWater, x, y))
                isWater[x][y] = 2;
        }
    }

    public void incrementNeighbor(int[][] isWater, int i, int j, int[][] dirs, boolean[][] visited){
        visited[i][j]= true;
        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            if(isValid(isWater, x, y) && !visited[x][y])
                isWater[x][y] = isWater[i][j]+1;
        }
    }


    public boolean isValid(int[][] isWater, int x, int y){
        if(x<0 || y<0 || x >=isWater.length || y >= isWater[0].length || isWater[x][y]!=0)
            return false;
        return true;
    }
}