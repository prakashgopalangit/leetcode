package com.prakash.leetcode.NewStart.Graph;

import java.util.*;

public class NumberOfConnectedComponentsInAnUndirectedGraph {

    public static void main(String[] args) {

        int n = 5;
        int[][] edges = {{0,1},{1,2},{2,3},{3,4}};

        System.out.println(" numberOfComponents ---> "+ new NumberOfConnectedComponentsInAnUndirectedGraphSolution().countComponents(n, edges));
        System.out.println(" numberOfComponents ---> "+ new NumberOfConnectedComponentsInAnUndirectedGraphSolution_Idea2().countComponents(n, edges));

    }
}


/** second idea */
class NumberOfConnectedComponentsInAnUndirectedGraphSolution_Idea2{

    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++) list.add(new ArrayList<>());
        for(int[] edge : edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int numberOfConnectedComponents = 0;

        System.out.println(" list ---> "+ list);
        for(int i=0;i<n;i++){
            System.out.println(" visited ---> "+ Arrays.toString(visited));
            if(!visited[i]){
                numberOfConnectedComponents++;
                dfs(list, i, visited);
            }
        }
        return numberOfConnectedComponents;
    }

    public void dfs(List<List<Integer>> list, int node, boolean[] visited){
        visited[node] = true;
        for(int neighbor : list.get(node))
           if(!visited[neighbor])
               dfs(list, neighbor, visited);
    }
}


/** first idea */
class NumberOfConnectedComponentsInAnUndirectedGraphSolution{

    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++) list.add(new ArrayList<>());
        for(int[] edge : edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int numberOfConnectedComponents = 0;
        Queue<Integer> queue = new LinkedList<>();

        System.out.println(" list ---> "+ list);
        for(int i=0;i<n;i++){
            System.out.println(" visited ---> "+ Arrays.toString(visited));
            if(!visited[i]){
                numberOfConnectedComponents++;
                queue.offer(i);
                while(!queue.isEmpty()){
                   int node = queue.poll();
                   visited[node] = true;
                   for(int neighbor : list.get(node)){
                       if(!visited[neighbor]){
                           queue.offer(neighbor);
                       }
                   }
                }
            }

        }
        return numberOfConnectedComponents;
    }
}
