package com.prakash.leetcode.NewStart.Graph;

import java.util.*;

public class BipartiteGraph {

    public static void main(String[] args) {
        int[][] graph = {{1},{0,3},{3},{1,2}};
        System.out.println(" is Bipartite graph --> "+ new BipartiteGraphSolution().isBipartite(graph));
        System.out.println(" is Bipartite graph --> "+ new BipartiteGraphSolutionBFS().isBipartite(graph));
    }
}

//DFS solution
class BipartiteGraphSolution{
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(colors[i] ==0 && !isValidColor(graph, i, 1, colors)){
                return false;
            }
        }
        System.out.println("colors ---> "+ Arrays.toString(colors));
        return true;
    }

    public boolean isValidColor(int[][] graph, int i, int color, int[] colors){
        if(colors[i]!=0){
            return colors[i]==color;
        }
        colors[i] = color;
        for(int neigbor : graph[i]){
            if(!isValidColor(graph, neigbor, -color, colors)){
                return false;
            }
        }

        return true;
    }
}

//BFS solution
class BipartiteGraphSolutionBFS{
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(colors[i]==0){
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                colors[i] = 1;
                while(!queue.isEmpty()){
                    int node = queue.poll();
                    for(int neigbor : graph[node]){
                        if(colors[neigbor]==0){
                            colors[neigbor] = -colors[node];
                            queue.offer(neigbor);
                        }else if(colors[neigbor] == colors[node]){
                            return false;

                        }
                    }
                }

            }
        }
        return true;

    }
}