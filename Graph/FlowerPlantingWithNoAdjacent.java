package com.prakash.leetcode.NewStart.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlowerPlantingWithNoAdjacent {

    public static void main(String[] args) {
        int n = 5;
        int[][] paths = {{3,4},{4,5},{3,2},{5,1},{1,3},{4,2}};

        System.out.println(" " + new FlowerPlantingWithNoAdjacentSolution().gardenNoAdj(n, paths));
    }
}

class FlowerPlantingWithNoAdjacentSolution{

    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> list = new ArrayList<>();
        int[] colors = new int[n];
        boolean[] visited = new boolean[n+1];
        for(int i=0;i<=n;i++) list.add(new ArrayList<>());
        for(int[] path : paths){
            list.get(path[0]).add(path[1]);
            list.get(path[1]).add(path[0]);
        }

        for(List<Integer> innerList : list){
            System.out.println("innerList ---> " + innerList);
        }

        for(int i=1;i<=n;i++){
           if(!visited[i]){
               dfs(list, colors, visited, i, 1);
           }
        }
        System.out.println(" colors ---> "+ Arrays.toString(colors));
        return colors;
    }

    public void dfs(List<List<Integer>> list, int[] colors, boolean[] visited, int garden, int color){
        if(visited[garden]) return;
        visited[garden] = true;
        colors[garden-1] = color;
        for(int neighborGarden : list.get(garden)){
            if(!visited[neighborGarden]){
                dfs(list, colors, visited, neighborGarden, color+1);
            }
        }
    }
}
