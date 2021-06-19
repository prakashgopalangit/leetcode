package com.prakash.leetcode.NewStart.Graph;

import java.util.Arrays;
import java.util.List;

public class CheckIfThereIsAValidPathInAGrid {


    public static void main(String[] args) {
        int[][] grid = {{4,1,3},{6,1,2}};



        System.out.println(" validPath---> "+ new CheckIfThereIsAValidPathInAGridSolution().hasValidPath(grid));
    }
}

class CheckIfThereIsAValidPathInAGridSolution{

    boolean pathExists;

    public boolean hasValidPath(int[][] grid) {
        int[][] dirs = {
                {0,-1,0,1},
                {-1,0,1,0},
                {0,-1,1,0},
                {1,0,0,1},
                {0,-1,-1,0},
                {-1,0,0,1}
        };
        //0 index - Left
        //1 index - Right
        //2 index - Up
        //3 index - Down
        List<List<Integer>> allowedList = Arrays.asList(Arrays.asList(1,4,6),Arrays.asList(1,3,5),Arrays.asList(2,3,4),Arrays.asList(2,5,6));
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(grid, dirs, visited, allowedList, 0, 0);
        return pathExists;

    }

    public void dfs(int[][] grid, int[][] dirs, boolean[][] visited, List<List<Integer>> allowedList, int x, int y){

        System.out.println(" =================================== ");
       visited[x][y] = true;
       if(x==grid.length-1 && y==grid[0].length-1) pathExists = true;
       int cellValue = grid[x][y];
        System.out.println(" x ---> "+ x + " & y ---> "+ y);
        System.out.println(" cellValue ---> " + cellValue);
       for(int i=0;i<dirs[cellValue-1].length;i=i+2){
           System.out.println( " i value ---> "+ i);
           System.out.println( " i+1 value ---> "+ (i+1));
           int newX = x + dirs[cellValue-1][i];
           int newY = y + dirs[cellValue-1][i+1];
           if(isValidRange(grid, newX, newY) && !visited[newX][newY]  && isNextCellValid(grid, cellValue, dirs[cellValue-1][i], dirs[cellValue-1][i+1], newX, newY, allowedList)) {
              dfs(grid, dirs, visited, allowedList, newX, newY);
           }else{
               System.out.println(" cell is not valid --> "+ " newX --> "+newX + " newY --> " + newY);
           }
       }
    }

    public boolean isValidRange(int[][] grid,  int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length)
            return false;
        return true;
    }

    public boolean isNextCellValid(int[][] grid, int cellValue, int xAxis, int yAxis, int newX, int newY, List<List<Integer>> allowedList){
        System.out.println(" cellValue inside isNextCellValid method " + cellValue );
        System.out.println(" grid[newX][newY] inside isNextCellValid method " + grid[newX][newY] );
        System.out.println(" xAxis ---> "+ xAxis);
        System.out.println(" yAxis ---> "+ yAxis);

        if(cellValue==1){
            if(yAxis<0){
                return allowedList.get(0).contains(grid[newX][newY]);
            }else{
                return allowedList.get(1).contains(grid[newX][newY]);
            }
        }else if(cellValue==2){
            if(xAxis<0){
                return allowedList.get(2).contains(grid[newX][newY]);
            }else{
                return allowedList.get(3).contains(grid[newX][newY]);
            }
        }else if(cellValue==3){
            if(yAxis<0){
                return allowedList.get(0).contains(grid[newX][newY]);
            }else{
                return allowedList.get(3).contains(grid[newX][newY]);
            }
        }else if(cellValue==4){
            if(yAxis==0){
                return allowedList.get(3).contains(grid[newX][newY]);
            }else{
                return allowedList.get(1).contains(grid[newX][newY]);
            }
        }else if(cellValue==5){
            if(yAxis<0){
                return allowedList.get(0).contains(grid[newX][newY]);
            }else{
                return allowedList.get(2).contains(grid[newX][newY]);
            }
        }else{
            if(xAxis<0){
                return allowedList.get(2).contains(grid[newX][newY]);
            }else{
                return allowedList.get(1).contains(grid[newX][newY]);
            }
        }

    }

}
