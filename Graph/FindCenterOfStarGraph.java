package com.prakash.leetcode.NewStart.Graph;

import java.util.HashMap;
import java.util.Map;

public class FindCenterOfStarGraph {

    public static void main(String[] args) {
        int[][] edges = {{1,2},{2,3},{4,2}};
        System.out.println(" star of the graph --> "+ new FindCenterOfStarGraphSolution().findCenter(edges));


    }
}

class FindCenterOfStarGraphSolution {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = 0;
        for(int[] edge : edges){
            n = Math.max(n, Math.max(edge[0], edge[1]));
            map.put(edge[0], map.getOrDefault(edge[0], 0) + 1);
            map.put(edge[1], map.getOrDefault(edge[1], 0) + 1);
        }
        System.out.println(" map --> "+ map);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()==n-1)
                return entry.getKey();
        }
        return 0;
    }
}
