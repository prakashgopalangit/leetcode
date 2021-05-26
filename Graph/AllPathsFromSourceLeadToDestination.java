package com.prakash.leetcode.NewStart.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPathsFromSourceLeadToDestination {

    public static void main(String[] args) {
        int n = 2;
        int[][] edges = {{0,1},{1,1}};
        int source = 0, destination = 1;

        System.out.println(" boolean value ---> "+ new AllPathsFromSourceLeadToDestinationSolution().leadsToDestination(n, edges, source, destination));
    }

}

class AllPathsFromSourceLeadToDestinationSolution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[n];
        for(int[] edge : edges){
            List<Integer> list = map.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            map.put(edge[0], list);
        }
        System.out.println(" map ---> "+ map);
        return dfs(map, visited, source, destination);
    }

    public boolean dfs(Map<Integer, List<Integer>> map, boolean[] visited, int source, int destination){
        if(!map.containsKey(source))
            return source==destination;

        visited[source] = true;
        for(Integer neighbor : map.get(source)){
            System.out.println(" neighbor ---> "+ neighbor);
            System.out.println(" visited ---> "+ visited);
            if(visited[neighbor] || !dfs(map, visited, neighbor, destination))
                return false;
        }
        visited[source] = false;
        return true;
    }
}
